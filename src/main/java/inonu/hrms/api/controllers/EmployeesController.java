package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.EmployeeService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.tables.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private EmployeeService employeeServie;

    @Autowired
    public EmployeesController(EmployeeService employeeServie) {
        this.employeeServie = employeeServie;
    }

    @GetMapping(path = "")
    public ResponseEntity<DataResult<List<Employee>>> getAll(){
        return new ResponseEntity<>(this.employeeServie.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "save")
    public ResponseEntity<Result> save(@Valid @RequestBody Employee employee){

        Result result = this.employeeServie.save(employee);

        if(result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

    }
}