package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.CandidateVerificationService;
import inonu.hrms.business.abstracts.UserVerificationManager;
import inonu.hrms.core.dataAccess.abstracts.UserRepository;
import inonu.hrms.core.entities.User;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.ErrorDataResult;
import inonu.hrms.core.utilities.results.SuccessDataResult;
import inonu.hrms.dataAccess.abstracts.UserVerificationRepository;
import inonu.hrms.entities.tables.UserVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateVerificationManager extends UserVerificationManager implements CandidateVerificationService {

        private UserRepository userRepository;
    @Autowired
    public CandidateVerificationManager(UserVerificationRepository userVerificationRepository,UserRepository userRepository) {
        super(userVerificationRepository);
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<UserVerification> verificate(String code){
        DataResult<UserVerification> userVerification = super.verificate(code);

        if (!userVerification.isSuccess()){
            return new ErrorDataResult<UserVerification>(userVerification.getMessage(),null);
        }

        User user = this.userRepository.getById(userVerification.getData().getUserId());
        if (user != null){
            user.setActive(true);
            this.userRepository.save(user);
        }
        return new SuccessDataResult<UserVerification>(null);
    }
}
