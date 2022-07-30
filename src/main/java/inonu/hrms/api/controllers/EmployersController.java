package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.EmployerService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.tables.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/employers")
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("")
    public ResponseEntity<DataResult<List<Employer>>> getAll(){
        return new ResponseEntity<>(this.employerService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Result> save(@Valid @RequestBody Employer employer){
        DataResult<Employer> result = this.employerService.save(employer);
        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}