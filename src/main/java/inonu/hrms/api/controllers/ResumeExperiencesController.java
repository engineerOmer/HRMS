package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.ResumeExperienceService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.tables.ResumeExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/resume-experiences")
public class ResumeExperiencesController {
    private ResumeExperienceService resumeExperienceService;

    @Autowired
    public ResumeExperiencesController(ResumeExperienceService resumeExperienceService) {
        this.resumeExperienceService = resumeExperienceService;
    }

    @GetMapping("resume-id/{resumeId}")
    public DataResult<List<ResumeExperience>> getAllByResumeId(@PathVariable("resumeId") int resumeId){
        return this.resumeExperienceService.getAllByResumeId(resumeId);
    }

    @GetMapping("resume-id/{resumeId}/order")
    public DataResult<List<ResumeExperience>> getAllByResumeIdOrderBy(@PathVariable("resumeId") int resumeId, Sort.Direction direciton, String fieldName ){
        return this.resumeExperienceService.getAllByResumeIdOrderBy(resumeId, direciton, fieldName);
    }

    @PostMapping("save")
    public ResponseEntity<Result> save(@Valid @RequestBody ResumeExperience resumeExperience) {
        Result result = this.resumeExperienceService.save(resumeExperience);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}