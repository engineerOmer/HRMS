package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.EmployerVerificationService;
import inonu.hrms.business.abstracts.UserVerificationManager;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.dataAccess.abstracts.UserVerificationRepository;
import inonu.hrms.entities.tables.UserVerification;
import org.springframework.stereotype.Service;
@Service
public class EmployerVerificationManager extends UserVerificationManager implements EmployerVerificationService {

    public EmployerVerificationManager(UserVerificationRepository userVerificationRepository) {
        super(userVerificationRepository);
    }

    @Override
    public DataResult<UserVerification> generate(int userId) {
        return super.generate(userId);
    }

    @Override
    public DataResult<UserVerification> verificate(String code) {
        return super.verificate(code);
    }


}
