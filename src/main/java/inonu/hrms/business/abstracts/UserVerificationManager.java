package inonu.hrms.business.abstracts;

import inonu.hrms.business.constants.ValidationMessages;
import inonu.hrms.core.utilities.business.CheckEngine;
import inonu.hrms.core.utilities.results.*;
import inonu.hrms.dataAccess.abstracts.UserVerificationRepository;
import inonu.hrms.entities.tables.UserVerification;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public abstract class UserVerificationManager implements UserVerificationService{
        private UserVerificationRepository userVerificationRepository;

        @Autowired
        public UserVerificationManager(UserVerificationRepository userVerificationRepository) {
            this.userVerificationRepository = userVerificationRepository;
        }



        @Override
        public DataResult<UserVerification> generate(int userId) {
            UUID uuid = UUID.randomUUID();

            UserVerification userVerification = new UserVerification();
            userVerification.setUserId(userId);
            userVerification.setCode(uuid.toString());
            userVerification.setExpiryDate(Instant.now().plus(24, ChronoUnit.HOURS));
            this.userVerificationRepository.save(userVerification);

            return new SuccessDataResult<UserVerification>(userVerification);
        }

        @Override
        public DataResult<UserVerification> verificate(String code) {

            int userId = this.userVerificationRepository.findUserIdByCode(code);

            Result result = CheckEngine.run(
                    this.checkIfCodeIsNotExists(code),
                    this.checkIfUserIsAlreadyVerificated(userId)
            );

            if(!result.isSuccess()) {
                return new ErrorDataResult<UserVerification>(result.getMessage(),null);
            }

            UserVerification userVerification = this.userVerificationRepository.findByCode(code);
            userVerification.setVerificationDate(Instant.now());
            this.userVerificationRepository.save(userVerification);
            return new SuccessDataResult<UserVerification>(userVerification);
        }

        private Result checkIfCodeIsNotExists(String code) {
            boolean result = this.userVerificationRepository.existsByCode(code);

            if(!result) {
                return new ErrorResult(ValidationMessages.VERIFICATION_CODE_IS_NOT_EXISTS);
            }

            return new SuccessResult();
        }

        private Result checkIfUserIsAlreadyVerificated(int userId) {
            boolean result = this.userVerificationRepository.userIsVerificated(userId);

            if(result) {
                return new ErrorResult(ValidationMessages.USER_IS_ALREADY_VERIFICATED);
            }

            return new SuccessResult();
        }
}
