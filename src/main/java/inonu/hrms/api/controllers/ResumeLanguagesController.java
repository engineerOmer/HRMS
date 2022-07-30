package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.ResumeLanguageService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.dtos.resumes.ResumeLanguageDetailDto;
import inonu.hrms.entities.tables.ResumeLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/resume-languages")
public class ResumeLanguagesController {
    private ResumeLanguageService resumeLanguageService;

    @Autowired
    public ResumeLanguagesController(ResumeLanguageService resumeLanguageService) {
        this.resumeLanguageService = resumeLanguageService;
    }

    @GetMapping("resume-id/{resumeId}")
    public ResponseEntity<DataResult<List<ResumeLanguageDetailDto>>> getAllByResumeId(@PathVariable("resumeId") int resumeId){
        return new ResponseEntity<>(this.resumeLanguageService.getAllDetailDtoByResumeId(resumeId), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Result> save(@Valid @RequestBody ResumeLanguage resumeLanguage){
        Result result = this.resumeLanguageService.save(resumeLanguage);
        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
