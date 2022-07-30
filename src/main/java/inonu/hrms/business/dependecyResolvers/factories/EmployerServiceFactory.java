package inonu.hrms.business.dependecyResolvers.factories;

import inonu.hrms.business.abstracts.EmployerVerificationService;
import inonu.hrms.business.abstracts.MailSendService;
import inonu.hrms.business.abstracts.UserCheckService;
import inonu.hrms.dataAccess.abstracts.EmployerRepository;

public interface EmployerServiceFactory {
    EmployerRepository employerRepository();
    UserCheckService userCheckService();
    MailSendService mailSendService();
    EmployerVerificationService employerVerificationService();
}
