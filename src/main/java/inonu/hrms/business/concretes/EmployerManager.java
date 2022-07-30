package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.EmployerService;
import inonu.hrms.business.constants.MailTemplates;
import inonu.hrms.business.constants.Messages;
import inonu.hrms.business.constants.ValidationMessages;
import inonu.hrms.business.dependecyResolvers.factories.EmployerServiceFactory;
import inonu.hrms.core.utilities.business.CheckEngine;
import inonu.hrms.core.utilities.results.*;
import inonu.hrms.entities.tables.Employer;
import inonu.hrms.entities.tables.UserVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployerManager implements EmployerService {

    private EmployerServiceFactory factory;

    @Autowired
    public EmployerManager(EmployerServiceFactory employerServiceFactory) {
        this.factory = employerServiceFactory;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.factory.employerRepository().findAll());
    }

    @Override
    public DataResult<Employer> save(Employer employer) {

        Result result = CheckEngine.run(
                checkIfEmailAlreadyExists(employer.getEmail(), employer.getId()),
                checkIfNotBeTheSameEmailAndWebsite(employer)
        );

        if(!result.isSuccess()) {
            return new DataResult<>(result.isSuccess(), result.getMessage(), null);
        }

        this.factory.employerRepository().save(employer);
        DataResult<UserVerification> userVerification = this.factory.employerVerificationService().generate(employer.getId());
        if(userVerification.isSuccess()) {
            this.factory.mailSendService().sendMail(
                    employer.getEmail(),
                    Messages.USER_VERIFICATION_SUBJECT,
                    MailTemplates.CANDIDATE_VERIFICATION_BODY.replace("{code}",userVerification.getData().getCode()));
        }

        return new SuccessDataResult<>(Messages.EMPLOYER_SAVE_IS_SUCCESSFUL, employer);
    }

    // Checks & Rules

    private Result checkIfNotBeTheSameEmailAndWebsite(Employer employer)
    {
        int atIndex = employer.getEmail().indexOf("@");
        String mailDomain = employer.getEmail().substring(atIndex + 1);

        if(!employer.getWebsite().contains(mailDomain)) {
            return new ErrorResult(ValidationMessages.EMAIL_AND_WEBSITE_MUST_BE_THE_SAME);
        }

        return new SuccessResult();
    }

    private Result checkIfEmailAlreadyExists(String email, int userId) {
        return this.factory.userCheckService().checkIfEmailAlreadyExists(email, userId);
    }

}
