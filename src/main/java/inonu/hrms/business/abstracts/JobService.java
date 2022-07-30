package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.entities.dtos.JobSummaryDto;
import inonu.hrms.entities.tables.Job;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface JobService {
        DataResult<List<Job>> getAll();
        DataResult<List<JobSummaryDto>> getAllJobSummaryDto();
        DataResult<List<JobSummaryDto>> getAllJobSummaryDtoSorted(Sort.Direction direction, String property);
        DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByCompanyName(String companyName);
        DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByJobTitle(String jobTitle);
        DataResult<Job> save(Job job);
        DataResult<Job> setActive(int id, boolean status);
}
