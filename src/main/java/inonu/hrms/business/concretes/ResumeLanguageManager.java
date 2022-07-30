package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.ResumeLanguageService;
import inonu.hrms.core.utilities.mappers.ModelMapperUtils;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.core.utilities.results.SuccessDataResult;
import inonu.hrms.core.utilities.results.SuccessResult;
import inonu.hrms.dataAccess.abstracts.ResumeLanguageRepository;
import inonu.hrms.entities.dtos.resumes.ResumeLanguageDetailDto;
import inonu.hrms.entities.tables.ResumeLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResumeLanguageManager implements ResumeLanguageService {

    private ResumeLanguageRepository resumeLanguageRepository;

    @Autowired
    public ResumeLanguageManager(ResumeLanguageRepository resumeLanguageRepository) {
        this.resumeLanguageRepository = resumeLanguageRepository;
    }

    @Override
    public Result save(ResumeLanguage resumeLanguage) {
        this.resumeLanguageRepository.save(resumeLanguage);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<ResumeLanguage>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeLanguage>>(this.resumeLanguageRepository.findAllByResumeId(resumeId));
    }
    @Override
    public DataResult<List<ResumeLanguageDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeLanguageDetailDto>>(ModelMapperUtils.toList(this.getAllByResumeId(resumeId).getData(), ResumeLanguageDetailDto.class));
    }
}
