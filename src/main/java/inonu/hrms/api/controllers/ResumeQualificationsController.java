package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.ResumeQualificationService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.dtos.resumes.ResumeQualificationDetailDto;
import inonu.hrms.entities.tables.ResumeQualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/resume-qualifications")
public class ResumeQualificationsController {
    private ResumeQualificationService resumeQualificationService;

    @Autowired
    public ResumeQualificationsController(ResumeQualificationService resumeQualificationService) {
        this.resumeQualificationService = resumeQualificationService;
    }

    @GetMapping("")
    public ResponseEntity<DataResult<List<ResumeQualificationDetailDto>>> getAllByResumeId(@PathVariable("resumeId") int resumeId){
        return new ResponseEntity<>(this.resumeQualificationService.getAllDetailDtoByResumeId(resumeId), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Result> save(ResumeQualification resumeQualification){
        Result result = this.resumeQualificationService.save(resumeQualification);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
