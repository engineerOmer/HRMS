package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.ResumeWebsiteService;
import inonu.hrms.core.utilities.mappers.ModelMapperUtils;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.core.utilities.results.SuccessDataResult;
import inonu.hrms.core.utilities.results.SuccessResult;
import inonu.hrms.dataAccess.abstracts.ResumeWebsiteRepository;
import inonu.hrms.entities.dtos.resumes.ResumeWebsiteDetailDto;
import inonu.hrms.entities.tables.ResumeWebsite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResumeWebsiteManager implements ResumeWebsiteService {

    private ResumeWebsiteRepository resumeWebsiteRepository;

    @Autowired
    public ResumeWebsiteManager(ResumeWebsiteRepository resumeWebsiteRepository) {
        this.resumeWebsiteRepository = resumeWebsiteRepository;
    }

    @Override
    public Result save(ResumeWebsite resumeWebsite) {
        this.resumeWebsiteRepository.save(resumeWebsite);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<ResumeWebsite>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeWebsite>>(this.resumeWebsiteRepository.findAllByResumeId(resumeId));
    }

    @Override
    public DataResult<List<ResumeWebsiteDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeWebsiteDetailDto>>(
                ModelMapperUtils.toList(
                        this.getAllByResumeId(resumeId).getData(),
                        ResumeWebsiteDetailDto.class
                )
        );
    }
}
