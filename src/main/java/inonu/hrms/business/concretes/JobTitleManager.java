package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.JobTitleService;
import inonu.hrms.business.constants.Messages;
import inonu.hrms.business.constants.ValidationMessages;
import inonu.hrms.core.utilities.business.CheckEngine;
import inonu.hrms.core.utilities.results.*;
import inonu.hrms.dataAccess.abstracts.JobTitleRepository;
import inonu.hrms.entities.tables.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import inonu.hrms.core.utilities.results.DataResult;
import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleRepository jobTitleRepository;

    @Autowired
    public JobTitleManager(JobTitleRepository jobTitleRepository) {
        this.jobTitleRepository = jobTitleRepository;
    }


    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleRepository.findAll());
    }

    @Override
    public DataResult<JobTitle> save(JobTitle jobTitle) {

        Result result = CheckEngine.run(
                checkIfExistsJobTitle(jobTitle)
        );

        if(!result.isSuccess()) {
            return new DataResult<>(result.isSuccess(), result.getMessage(), null);
        }

        this.jobTitleRepository.save(jobTitle);

        return new SuccessDataResult<>(Messages.JOB_TITLE_SAVE_IS_SUCCESSFUL, jobTitle);
    }

    private Result checkIfExistsJobTitle(JobTitle jobTitle) {
        boolean result = this.jobTitleRepository.existsByTitle(jobTitle.getTitle());

        if(result) {
            return new ErrorResult(ValidationMessages.JOB_TITLE_ALREADY_EXISTS);
        }
        return new SuccessResult();
    }
}
