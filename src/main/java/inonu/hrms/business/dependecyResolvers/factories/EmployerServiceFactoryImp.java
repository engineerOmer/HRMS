package inonu.hrms.business.dependecyResolvers.factories;

import inonu.hrms.business.abstracts.EmployerVerificationService;
import inonu.hrms.business.abstracts.MailSendService;
import inonu.hrms.business.abstracts.UserCheckService;
import inonu.hrms.dataAccess.abstracts.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceFactoryImp implements EmployerServiceFactory {

    private EmployerRepository employerRepository;
    private UserCheckService userCheckService;
    private MailSendService mailSendService;
    private EmployerVerificationService employerVerificationService;

    @Autowired
    public EmployerServiceFactoryImp(EmployerRepository employerRepository, UserCheckService userCheckService, MailSendService mailSendService, EmployerVerificationService employerVerificationService) {
        this.employerRepository = employerRepository;
        this.userCheckService = userCheckService;
        this.mailSendService = mailSendService;
        this.employerVerificationService = employerVerificationService;
    }

    @Override
    public EmployerRepository employerRepository() {
        return employerRepository;
    }

    @Override
    public UserCheckService userCheckService() {
        return userCheckService;
    }

    @Override
    public MailSendService mailSendService() {
        return mailSendService;
    }

    @Override
    public EmployerVerificationService employerVerificationService() {
        return employerVerificationService;
    }

}