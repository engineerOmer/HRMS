package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.dtos.resumes.ResumeQualificationDetailDto;
import inonu.hrms.entities.tables.ResumeQualification;

import java.util.List;

public interface ResumeQualificationService {
    Result save(ResumeQualification resumeQualification);
    DataResult<List<ResumeQualification>> getAllByResumeId(int resumeId);
    DataResult<List<ResumeQualificationDetailDto>> getAllDetailDtoByResumeId(int resumeId);
}
