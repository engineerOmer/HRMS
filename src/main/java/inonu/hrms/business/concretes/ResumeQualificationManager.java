package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.ResumeQualificationService;
import inonu.hrms.core.utilities.mappers.ModelMapperUtils;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.core.utilities.results.SuccessDataResult;
import inonu.hrms.core.utilities.results.SuccessResult;
import inonu.hrms.dataAccess.abstracts.ResumeQualificationRepository;
import inonu.hrms.entities.dtos.resumes.ResumeQualificationDetailDto;
import inonu.hrms.entities.tables.ResumeQualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResumeQualificationManager implements ResumeQualificationService {

    private ResumeQualificationRepository resumeQualificationRepository;

    @Autowired
    public ResumeQualificationManager(ResumeQualificationRepository resumeQualificationRepository) {
        this.resumeQualificationRepository = resumeQualificationRepository;
    }

    @Override
    public Result save(ResumeQualification resumeQualification) {
        this.resumeQualificationRepository.save(resumeQualification);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<ResumeQualification>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeQualification>>(this.resumeQualificationRepository.findAllByResumeId(resumeId));
    }

    @Override
    public DataResult<List<ResumeQualificationDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeQualificationDetailDto>>(
                ModelMapperUtils.toList(
                        this.getAllDetailDtoByResumeId(resumeId).getData(),
                        ResumeQualificationDetailDto.class
                )
        );
    }
}
