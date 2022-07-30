package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.EmployeeService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.core.utilities.results.SuccessDataResult;
import inonu.hrms.core.utilities.results.SuccessResult;
import inonu.hrms.dataAccess.abstracts.EmployeeRepository;
import inonu.hrms.entities.tables.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Result save(Employee employee) {
        this.employeeRepository.save(employee);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeRepository.findAll());
    }

}