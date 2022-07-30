package inonu.hrms.business.dependecyResolvers.factories;

import inonu.hrms.core.dataAccess.abstracts.UserRepository;
import inonu.hrms.dataAccess.abstracts.EmployeeRepository;
import inonu.hrms.dataAccess.abstracts.EmployerRepository;
import inonu.hrms.dataAccess.abstracts.UserConfirmRepository;
import inonu.hrms.dataAccess.abstracts.UserVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerConfirmServiceFactoryImp implements EmployerConfirmServiceFactory{
    private UserConfirmRepository userConfirmRepository;
    private UserVerificationRepository userVerificationRepository;
    private UserRepository userRepository;
    private EmployeeRepository employeeRepository;
    private EmployerRepository employerRepository;

    @Autowired
    public EmployerConfirmServiceFactoryImp(UserConfirmRepository userConfirmRepository,UserVerificationRepository userVerificationRepository, UserRepository userRepository, EmployeeRepository employeeRepository, EmployerRepository employerRepository) {
        this.userConfirmRepository = userConfirmRepository;
        this.userVerificationRepository = userVerificationRepository;
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.employerRepository = employerRepository;
    }

    @Override
    public UserConfirmRepository userConfirmRepository() {
        return userConfirmRepository;
    }

    @Override
    public UserVerificationRepository userVerificationRepository() {
        return userVerificationRepository;
    }

    @Override
    public UserRepository userRepository() {
        return userRepository;
    }

    @Override
    public EmployeeRepository employeeRepository() {
        return employeeRepository;
    }

    @Override
    public EmployerRepository employerRepository() {
        return employerRepository;
    }


}