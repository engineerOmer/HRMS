package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.ResumeExperienceService;
import inonu.hrms.business.constants.ValidationMessages;
import inonu.hrms.core.utilities.business.CheckEngine;
import inonu.hrms.core.utilities.results.*;
import inonu.hrms.dataAccess.abstracts.ResumeExperienceRepository;
import inonu.hrms.entities.tables.ResumeExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.NullHandling;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResumeExperienceManager implements ResumeExperienceService {

    private ResumeExperienceRepository resumeExperienceRepository;
    @Autowired
    public ResumeExperienceManager(ResumeExperienceRepository resumeExperienceRepository) {
        this.resumeExperienceRepository = resumeExperienceRepository;
    }

    @Override
    public DataResult<List<ResumeExperience>> getAllByResumeId(int resumeId) {
        List<ResumeExperience> result = this.resumeExperienceRepository.findAllByResumeId(resumeId);
        return new SuccessDataResult<List<ResumeExperience>>(result);
    }

    @Override
    public DataResult<List<ResumeExperience>> getAllByResumeId(int resumeId, Sort sort) {
        List<ResumeExperience> result = this.resumeExperienceRepository.findAllByResumeId(resumeId, sort);
        return new SuccessDataResult<List<ResumeExperience>>(result);
    }

    @Override
    public DataResult<List<ResumeExperience>> getAllByResumeIdOrderBy(int id, Sort.Direction direction , String fieldName) {
        Sort.Order sortOrder = new Sort.Order(direction, fieldName,NullHandling.NULLS_LAST);
        Sort sort = Sort.by(sortOrder);

        return this.getAllByResumeId(id, sort);
    }

    @Override
    public Result save(ResumeExperience resumeExperience) {

        Result result = CheckEngine.run(
                checkIfIsNotContinuedThenEndDateNotNull(resumeExperience)
        );

        if(!result.isSuccess()) {
            return result;
        }

        this.resumeExperienceRepository.save(resumeExperience);
        return new SuccessResult();
    }

    private Result checkIfIsNotContinuedThenEndDateNotNull(ResumeExperience resumeExperience) {

        if(!resumeExperience.isContinued() && resumeExperience.getEndDate() != null) {
            return new ErrorResult(ValidationMessages.IF_IS_NOT_CONTINUED_THEN_END_DATE_CAN_NOT_BE_NULL);
        }

        return new SuccessResult();
    }
}
