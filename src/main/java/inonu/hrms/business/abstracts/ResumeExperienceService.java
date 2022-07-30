package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.tables.ResumeExperience;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ResumeExperienceService {
    DataResult<List<ResumeExperience>> getAllByResumeId(int id);
    DataResult<List<ResumeExperience>> getAllByResumeId(int id, Sort sort);
    DataResult<List<ResumeExperience>> getAllByResumeIdOrderBy(int id, Sort.Direction direction , String fieldName);
    Result save(ResumeExperience resumeExperience);
}
