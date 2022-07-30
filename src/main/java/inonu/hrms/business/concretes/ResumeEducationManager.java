package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.ResumeEducationService;
import inonu.hrms.business.constants.Messages;
import inonu.hrms.business.constants.ValidationMessages;
import inonu.hrms.core.utilities.business.CheckEngine;
import inonu.hrms.core.utilities.results.*;
import inonu.hrms.dataAccess.abstracts.ResumeEducationRepository;
import inonu.hrms.entities.tables.ResumeEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResumeEducationManager implements ResumeEducationService {

    private ResumeEducationRepository resumeEducationRepository;

    @Autowired
    public ResumeEducationManager(ResumeEducationRepository resumeEducationRepository) {
        this.resumeEducationRepository = resumeEducationRepository;
    }


    @Override
    public DataResult<List<ResumeEducation>> getAllByResumeId(int resumeId) {
        List<ResumeEducation> result = this.resumeEducationRepository.findAllByResumeId(resumeId);
        return new SuccessDataResult<List<ResumeEducation>>(result);
    }

    @Override
    public DataResult<List<ResumeEducation>> getAllByResumeId(int resumeId, Sort sort) {
        List<ResumeEducation> result = this.resumeEducationRepository.findAllByResumeId(resumeId, sort);
        return new SuccessDataResult<List<ResumeEducation>>(result);
    }

    @Override
    public DataResult<List<ResumeEducation>> getAllByResumeIdOrderBy(int id, Sort.Direction direction , String fieldName) {
        Sort.Order sortOrder = new Sort.Order(direction, fieldName, Sort.NullHandling.NULLS_LAST);
        Sort sort = Sort.by(sortOrder);

        return this.getAllByResumeId(id, sort);
    }

    @Override
    public DataResult<ResumeEducation> save(ResumeEducation resumeEducation) {

        Result result = CheckEngine.run(
                checkIfIsGraduateThenGraduateDateNotNull(resumeEducation)
        );

        if(!result.isSuccess()) {
            return new ErrorDataResult<>(result.getMessage(), resumeEducation);
        }

        this.resumeEducationRepository.save(resumeEducation);
        return new SuccessDataResult<>(Messages.RESUME_EDUCATION_SAVE_IS_SUCCESSFUL, resumeEducation);
    }

    private Result checkIfIsGraduateThenGraduateDateNotNull(ResumeEducation resumeEducation) {

        if(resumeEducation.isGraduate() && resumeEducation.getGraduateDate() != null) {
            return new ErrorResult(ValidationMessages.IF_IS_GRADUATE_THEN_GRADUATE_DATE_CAN_NOT_BE_NULL);
        }

        return new SuccessResult();
    }
}
