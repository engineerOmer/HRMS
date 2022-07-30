package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.JobService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.entities.dtos.JobSummaryDto;
import inonu.hrms.entities.tables.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/jobs")
@CrossOrigin
public class JobsController {

    private JobService jobService;

    @Autowired
    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("")
    public ResponseEntity<DataResult<List<Job>>> getAll() {
        return new ResponseEntity<>(this.jobService.getAll(), HttpStatus.OK);
    }

    @GetMapping("summary-table")
    public ResponseEntity<DataResult<List<JobSummaryDto>>> getAllJobSummaryDto(){
        return new ResponseEntity<>(this.jobService.getAllJobSummaryDto(), HttpStatus.OK);
    }

    @GetMapping("summary-table/order")
    public ResponseEntity<DataResult<List<JobSummaryDto>>> getAllJobSummaryDto(Sort.Direction sort, String property){
        return new ResponseEntity<>(this.jobService.getAllJobSummaryDtoSorted(sort, property), HttpStatus.OK);
    }

    @GetMapping("summary-table/contains/company-name")
    public ResponseEntity<DataResult<List<JobSummaryDto>>> getAllJobSummaryDtoByCompanyName(String companyName){
        return new ResponseEntity<>(this.jobService.getAllJobSummaryDtoByCompanyName(companyName), HttpStatus.OK);
    }

    @GetMapping("summary-table/contains/job-title")
    public ResponseEntity<DataResult<List<JobSummaryDto>>> getAllJobSummaryDtoByJobTitle(String jobTitle){
        return new ResponseEntity<>(this.jobService.getAllJobSummaryDtoByJobTitle(jobTitle), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<DataResult<Job>> save(@Valid @RequestBody Job job) {

        DataResult<Job> result = this.jobService.save(job);

        if (!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("{id}/set/active")
    public ResponseEntity<DataResult<Job>> setActive(@PathVariable(name = "id") int id){
        return this.setActiveAndPassive(id, true);
    }

    @PostMapping("{id}/set/passive")
    public ResponseEntity<DataResult<Job>> setPassive(@PathVariable(name = "id") int id){
        return this.setActiveAndPassive(id, false);
    }

    private ResponseEntity<DataResult<Job>> setActiveAndPassive(int id, boolean status){
        DataResult<Job> result = this.jobService.setActive(id, status);

        if (!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
