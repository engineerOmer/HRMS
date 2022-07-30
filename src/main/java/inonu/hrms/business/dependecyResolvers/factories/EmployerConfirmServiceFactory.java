package inonu.hrms.business.dependecyResolvers.factories;

import inonu.hrms.core.dataAccess.abstracts.UserRepository;
import inonu.hrms.dataAccess.abstracts.EmployeeRepository;
import inonu.hrms.dataAccess.abstracts.EmployerRepository;
import inonu.hrms.dataAccess.abstracts.UserConfirmRepository;
import inonu.hrms.dataAccess.abstracts.UserVerificationRepository;

public interface EmployerConfirmServiceFactory {
    UserConfirmRepository userConfirmRepository();
    UserVerificationRepository userVerificationRepository();
    UserRepository userRepository();
    EmployeeRepository employeeRepository();
    EmployerRepository employerRepository();
}
