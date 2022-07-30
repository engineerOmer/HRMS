package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.EmployerConfirmService;
import inonu.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employer-confirms")
@CrossOrigin
public class EmployerConfirmsController {
    private EmployerConfirmService employerConfirmService;

    @Autowired
    public EmployerConfirmsController(EmployerConfirmService employerConfirmService) {
        this.employerConfirmService = employerConfirmService;
    }

    @PostMapping("confirm")
    public ResponseEntity<Result> confirm(@RequestParam int userId, @RequestParam int confirmerUserId){
        Result result = this.employerConfirmService.confirm(userId, confirmerUserId);
        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}