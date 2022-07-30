package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.MediaService;
import inonu.hrms.business.abstracts.ResumeService;
import inonu.hrms.business.constants.Messages;
import inonu.hrms.business.constants.ValidationMessages;
import inonu.hrms.core.utilities.business.CheckEngine;
import inonu.hrms.core.utilities.mappers.ModelMapperUtils;
import inonu.hrms.core.utilities.results.*;
import inonu.hrms.dataAccess.abstracts.ResumeRepository;
import inonu.hrms.entities.dtos.resumes.ResumeDetailDto;
import inonu.hrms.entities.dtos.resumes.ResumeSummaryDto;
import inonu.hrms.entities.tables.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.util.List;
@Service
public class ResumeManager implements ResumeService {

    private ResumeRepository resumeRepository;
    private MediaService mediaService;

    @Autowired
    public ResumeManager(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public DataResult<List<ResumeSummaryDto>> getAllSummaryDto() {
        return new SuccessDataResult<List<ResumeSummaryDto>>(ModelMapperUtils.toList(
                this.resumeRepository.findAll(),
                ResumeSummaryDto.class)
        );
    }

    @Override
    public DataResult<List<ResumeDetailDto>> getDetailDtoById(int id) {
        return new SuccessDataResult<List<ResumeDetailDto>>(ModelMapperUtils.toList(
                this.resumeRepository.findAll(),
                ResumeDetailDto.class)
        );
    }

    @Override
    public DataResult<Resume> save(Resume resume) {
        this.resumeRepository.save(resume);
        return new SuccessDataResult<>(Messages.RESUME_SAVE_IS_SUCCESSFUL, resume);
    }

    @Override
    public DataResult<Resume> setImage(int id, File file) {

        Result result = CheckEngine.run(
                CheckResumeIfNotExists(id)
        );

        if(!result.isSuccess()) {
            return new ErrorDataResult<>(result.getMessage(), null);
        }

        DataResult<MediaResult> imageResult = this.mediaService.setImage(file);
        Resume resume = getById(id).getData();
        resume.setProfilePictureUrl(imageResult.getData().getUrl());
        this.save(resume);

        return new SuccessDataResult<Resume>(imageResult.getData().getUrl(), resume);
    }

    @Override
    public DataResult<Resume> getById(int id) {
        return new SuccessDataResult<Resume>(this.resumeRepository.findById(id).orElse(null));
    }

    private Result CheckResumeIfNotExists(int id) {
        boolean result = this.resumeRepository.existsById(id);
        if(!result) {
            return new ErrorResult(ValidationMessages.RESUME_IS_NOT_EXISTS);
        }

        return new SuccessResult();
    }

}
