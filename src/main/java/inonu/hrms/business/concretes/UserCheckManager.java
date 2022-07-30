package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.UserCheckService;
import inonu.hrms.business.constants.ValidationMessages;
import inonu.hrms.core.dataAccess.abstracts.UserRepository;
import inonu.hrms.core.utilities.results.ErrorResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCheckManager implements UserCheckService {

    private UserRepository userRepository;

    @Autowired
    public UserCheckManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Result checkIfEmailAlreadyExists(String email, int id) {
        boolean result = this.userRepository.existsByEmailAndIdNot(email, id);

        if(result) {
            return new ErrorResult(ValidationMessages.USER_EMAIL_IS_ALREADY_EXISTS);
        }

        return new SuccessResult();
    }
}
