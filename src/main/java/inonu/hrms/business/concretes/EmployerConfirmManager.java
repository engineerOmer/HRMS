package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.EmployerConfirmService;
import inonu.hrms.business.constants.ValidationMessages;
import inonu.hrms.business.dependecyResolvers.factories.EmployerConfirmServiceFactory;
import inonu.hrms.core.entities.User;
import inonu.hrms.core.utilities.business.CheckEngine;
import inonu.hrms.core.utilities.results.ErrorResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.core.utilities.results.SuccessResult;
import inonu.hrms.entities.tables.UserConfirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class EmployerConfirmManager implements EmployerConfirmService {

    private EmployerConfirmServiceFactory factory;

    @Autowired
    public EmployerConfirmManager(EmployerConfirmServiceFactory factory) {
        this.factory = factory;
    }


    @Override
    public Result confirm(int userId, int confirmerUserId) {
        Result result = CheckEngine.run(
                this.checkIfConfirmerIsNotEmployee(confirmerUserId),
                this.checkIfUserIsNotEmployer(userId),
                this.checkIfUserIsNotVerificated(userId),
                this.checkIfUserAlreadyConfirmed(userId)
        );

        if(!result.isSuccess()) {
            return result;
        }

        User user = this.factory.userRepository().getById(userId);
        user.setActive(true);
        this.factory.userRepository().save(user);


        UserConfirm userConfirm = new UserConfirm();
        userConfirm.setUserId(userId);
        userConfirm.setConfirmedUserId(confirmerUserId);
        userConfirm.setConfirmedDate(Instant.now());
        //userConfirm.setConfirmed(true);
        this.factory.userConfirmRepository().save(userConfirm);

        return new SuccessResult();
    }


    private Result checkIfUserIsNotVerificated(int userId) {
        boolean result = this.factory.userVerificationRepository().userIsVerificated(userId);
        if(!result) {
            return new ErrorResult(ValidationMessages.USER_IS_MUST_BE_VERIFIED_FIRST);
        }

        return new SuccessResult();
    }

    private Result checkIfUserAlreadyConfirmed(int userId) {
        boolean result = this.factory.userConfirmRepository().isConfirmed(userId);
        if(result) {
            return new ErrorResult(ValidationMessages.USER_IS_ALREADY_CONFIRMED);
        }

        return new SuccessResult();
    }

    private Result checkIfConfirmerIsNotEmployee(int confirmerUserId) {
        boolean result = this.factory.employeeRepository().existsById(confirmerUserId);
        if(!result) {
            return new ErrorResult(ValidationMessages.CONFIRMER_IS_NOT_EMPLOYEE);
        }

        return new SuccessResult();
    }

    private Result checkIfUserIsNotEmployer(int userId) {
        boolean result = this.factory.employerRepository().existsById(userId);
        if(!result) {
            return new ErrorResult(ValidationMessages.USER_IS_NOT_EMPLOYER);
        }

        return new SuccessResult();
    }


}