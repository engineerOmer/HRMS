package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.JobTitleService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.tables.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/job-titles")
public class JobTitlesController {

    private JobTitleService jobTitleService;

    @Autowired
    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("")
    public ResponseEntity<DataResult<List<JobTitle>>> getAll(){
        return new ResponseEntity<>(this.jobTitleService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Result> save(@Valid @RequestBody JobTitle jobTitle){
        Result result = this.jobTitleService.save(jobTitle);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}