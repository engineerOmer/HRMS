package inonu.hrms.business.dependecyResolvers.factories;

import inonu.hrms.business.abstracts.CandidateVerificationService;
import inonu.hrms.business.abstracts.IdentityValidationService;
import inonu.hrms.business.abstracts.MailSendService;
import inonu.hrms.business.abstracts.UserCheckService;
import inonu.hrms.dataAccess.abstracts.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceFactoryImp implements CandidateServiceFactory {

    private CandidateRepository candidateRepository;
    private IdentityValidationService identityValidationService;
    private CandidateVerificationService candidateVerificationService;
    private UserCheckService userCheckService;
    private MailSendService mailSendService;

    @Autowired
    public CandidateServiceFactoryImp(CandidateRepository candidateRepository, IdentityValidationService identityValidationService, CandidateVerificationService candidateVerificationService, UserCheckService userCheckService, MailSendService mailSendService) {
        this.candidateRepository = candidateRepository;
        this.identityValidationService = identityValidationService;
        this.candidateVerificationService = candidateVerificationService;
        this.userCheckService = userCheckService;
        this.mailSendService = mailSendService;
    }

    @Override
    public CandidateRepository candidateRepository() {
        return candidateRepository;
    }

    @Override
    public IdentityValidationService identityValidationService() {
        return identityValidationService;
    }

    @Override
    public CandidateVerificationService candidateVerificationService() {
        return candidateVerificationService;
    }

    @Override
    public UserCheckService userCheckService() {
        return userCheckService;
    }

    @Override
    public MailSendService mailSendService() {
        return mailSendService;
    }

}