package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.CandidateService;
import inonu.hrms.business.constants.MailTemplates;
import inonu.hrms.business.constants.Messages;
import inonu.hrms.business.constants.ValidationMessages;
import inonu.hrms.business.dependecyResolvers.factories.CandidateServiceFactory;
import inonu.hrms.core.utilities.business.CheckEngine;
import inonu.hrms.core.utilities.results.*;

import inonu.hrms.entities.tables.Candidate;
import inonu.hrms.entities.tables.UserVerification;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateServiceFactory factory;

    public CandidateManager(CandidateServiceFactory factory) {
        this.factory = factory;
    }

    @Override
    public DataResult<Candidate> save(Candidate candidate) {

        Result result = CheckEngine.run(checkCandidateIsNotRealPerson(candidate),
                checkIfEmailAlreadyExists(candidate.getEmail(), candidate.getId()),
                checkIfIdentityNumberAlreadyExists(candidate));

        if (!result.isSuccess()) {
            return new ErrorDataResult<Candidate>(result.getMessage(), null);
        }

        this.factory.candidateRepository().save(candidate);
        this.opVerificationCodeGenerateAndSendMail(candidate);

        return new SuccessDataResult<Candidate>(candidate);
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.factory.candidateRepository().findAll());
    }


    // Operations

    private void opVerificationCodeGenerateAndSendMail(Candidate candidate) {

        if (!this.factory.candidateRepository().existsById(candidate.getId())) {
            DataResult<UserVerification> userVerification = this.factory.candidateVerificationService().generate(candidate.getId());
            if (userVerification.isSuccess()) {
                this.factory.mailSendService().sendMail(
                        candidate.getEmail(),
                        Messages.USER_VERIFICATION_SUBJECT,
                        MailTemplates.CANDIDATE_VERIFICATION_BODY.replace("{code}",userVerification.getData().getCode())
                );
            }
        }
    }

    // Checks & Rules

    private Result checkCandidateIsNotRealPerson(Candidate candidate) {
        Result identityResult = this.factory.identityValidationService().checkIdentityNumber(
                candidate.getIdentityNumber(),
                candidate.getFirstName(),
                candidate.getLastName(),
                candidate.getBirthDate()
        );
        if (identityResult.isSuccess()) {
            return new ErrorResult(ValidationMessages.PERSON_ID_VERIFICATION);
        }
        return new SuccessResult();
    }

    private Result checkIfIdentityNumberAlreadyExists(Candidate candidate) {
        boolean result = this.factory.candidateRepository().existsByIdentityNumberAndIdNot(candidate.getIdentityNumber(), candidate.getId());
        if (result) {
            return new ErrorResult(ValidationMessages.USER_IDENTITY_NUMBER_IS_ALREADY_EXISTS);
        }
        return new SuccessResult();
    }

    private Result checkIfEmailAlreadyExists(String email, int userId) {
        return this.factory.userCheckService().checkIfEmailAlreadyExists(email, userId);
    }

}