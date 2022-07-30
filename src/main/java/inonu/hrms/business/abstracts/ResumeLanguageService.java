package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.dtos.resumes.ResumeLanguageDetailDto;
import inonu.hrms.entities.tables.ResumeLanguage;

import java.util.List;

public interface ResumeLanguageService {
    Result save(ResumeLanguage resumeLanguage);
    DataResult<List<ResumeLanguage>> getAllByResumeId(int resumeId);
    DataResult<List<ResumeLanguageDetailDto>> getAllDetailDtoByResumeId(int resumeId);
}
