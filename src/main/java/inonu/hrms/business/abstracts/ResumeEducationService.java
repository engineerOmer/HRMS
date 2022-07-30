package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.entities.tables.ResumeEducation;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ResumeEducationService {
    DataResult<List<ResumeEducation>> getAllByResumeId(int id);
    DataResult<List<ResumeEducation>> getAllByResumeId(int id, Sort sort);
    DataResult<List<ResumeEducation>> getAllByResumeIdOrderBy(int id, Sort.Direction direction , String fieldName);
    DataResult<ResumeEducation> save(ResumeEducation resumeEducation);
}
