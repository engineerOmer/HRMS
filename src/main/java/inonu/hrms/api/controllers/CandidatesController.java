package inonu.hrms.api.controllers;
import inonu.hrms.business.abstracts.CandidateService;
import inonu.hrms.business.constants.ValidationMessages;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.ErrorDataResult;
import inonu.hrms.entities.tables.Candidate;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/candidates")
@CrossOrigin
public class CandidatesController {
    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }
    @GetMapping(path = "")
    public ResponseEntity<DataResult<List<Candidate>>> getAll(){
        return new ResponseEntity<>(this.candidateService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "save")
    public ResponseEntity<DataResult<Candidate>> save(@Valid @RequestBody Candidate candidate){

        DataResult<Candidate> result = this.candidateService.save(candidate);

        if(result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(ValidationMessages.VALIDATION_ERROR,validationErrors);
        return errors;
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleSqlConstraintException(ConstraintViolationException exceptions)
    {
        Map<String, String> validationError = new HashMap<String, String>();
        validationError.put("message", exceptions.getCause().getMessage());
        validationError.put("constraint", exceptions.getConstraintName());
        return new ErrorDataResult<Object>(validationError);
    }
}