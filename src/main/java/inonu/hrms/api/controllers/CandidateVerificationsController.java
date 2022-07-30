package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.CandidateVerificationService;
import inonu.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/candidate-verifications")
public class CandidateVerificationsController {
    private CandidateVerificationService candidateVerificationService;

    @Autowired
    public CandidateVerificationsController(CandidateVerificationService candidateVerificationService) {
        this.candidateVerificationService = candidateVerificationService;
    }

    @GetMapping("verificate/{code}")
    public ResponseEntity<Result> verificate(@PathVariable("code") String code){
        Result result = this.candidateVerificationService.verificate(code);
        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
