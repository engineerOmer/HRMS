package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.dtos.resumes.ResumeWebsiteDetailDto;
import inonu.hrms.entities.tables.ResumeWebsite;

import java.util.List;

public interface ResumeWebsiteService {
    Result save(ResumeWebsite resumeWebsite);
    DataResult<List<ResumeWebsite>> getAllByResumeId(int resumeId);
    DataResult<List<ResumeWebsiteDetailDto>> getAllDetailDtoByResumeId(int resumeId);
}
