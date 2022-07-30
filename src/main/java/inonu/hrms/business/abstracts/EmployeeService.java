package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.tables.Employee;

import java.util.List;

public interface EmployeeService {
    Result save(Employee employee);
    DataResult<List<Employee>> getAll();
}
