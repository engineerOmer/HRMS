package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.ResumeWebsiteService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.dtos.resumes.ResumeWebsiteDetailDto;
import inonu.hrms.entities.tables.ResumeWebsite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/resume-websites")
public class ResumeWebsitesController {
    private ResumeWebsiteService resumeWebsiteService;

    @Autowired
    public ResumeWebsitesController(ResumeWebsiteService resumeWebsiteService) {
        this.resumeWebsiteService = resumeWebsiteService;
    }

    @GetMapping("resume-id/{resumeId}")
    public ResponseEntity<DataResult<List<ResumeWebsiteDetailDto>>> getAllByResumeId(@PathVariable(name = "resumeId", required = true) int resumeId){
        return new ResponseEntity<>(this.resumeWebsiteService.getAllDetailDtoByResumeId(resumeId), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Result> save(@Valid @RequestBody ResumeWebsite resumeWebsite){
        Result result = this.resumeWebsiteService.save(resumeWebsite);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}