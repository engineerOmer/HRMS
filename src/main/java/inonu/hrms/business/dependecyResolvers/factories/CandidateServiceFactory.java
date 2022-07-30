package inonu.hrms.business.dependecyResolvers.factories;

import inonu.hrms.business.abstracts.CandidateVerificationService;
import inonu.hrms.business.abstracts.IdentityValidationService;
import inonu.hrms.business.abstracts.MailSendService;
import inonu.hrms.business.abstracts.UserCheckService;
import inonu.hrms.dataAccess.abstracts.CandidateRepository;

public interface CandidateServiceFactory {
        CandidateRepository candidateRepository();
        IdentityValidationService identityValidationService();
        CandidateVerificationService candidateVerificationService();
        UserCheckService userCheckService();
        MailSendService mailSendService();
}
