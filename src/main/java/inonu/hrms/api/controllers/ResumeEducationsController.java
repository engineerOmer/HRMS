package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.ResumeEducationService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.entities.tables.ResumeEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/resume-educations")
public class ResumeEducationsController {

    private ResumeEducationService resumeEducationService;

    @Autowired
    public ResumeEducationsController(ResumeEducationService resumeEducationService) {
        this.resumeEducationService = resumeEducationService;
    }

    @GetMapping("resume-id/{resumeId}")
    public DataResult<List<ResumeEducation>> getAllByResumeId(@PathVariable("resumeId") int resumeId){
        return this.resumeEducationService.getAllByResumeId(resumeId);
    }

    @GetMapping("resume-id/{resumeId}/order")
    public DataResult<List<ResumeEducation>> getAllByResumeIdOrderBy(@PathVariable("resumeId") int resumeId, Sort.Direction direciton, String fieldName ){
        return this.resumeEducationService.getAllByResumeIdOrderBy(resumeId, direciton, fieldName);
    }

    @PostMapping("save")
    public ResponseEntity<DataResult<ResumeEducation>> save(@Valid @RequestBody ResumeEducation resumeEducation) {
        DataResult<ResumeEducation> result = this.resumeEducationService.save(resumeEducation);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}