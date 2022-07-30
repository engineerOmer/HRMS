package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
