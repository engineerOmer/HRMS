package inonu.hrms.business.abstracts;

import org.cloudinary.json.JSONObject;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.entities.dtos.resumes.ResumeDetailDto;
import inonu.hrms.entities.dtos.resumes.ResumeSummaryDto;
import inonu.hrms.entities.tables.Resume;

import java.io.File;
import java.util.List;

public interface ResumeService {
    DataResult<List<ResumeSummaryDto>> getAllSummaryDto();
    DataResult<List<ResumeDetailDto>> getDetailDtoById(int id);
    DataResult<Resume> setImage(int id, File file);
    DataResult<Resume> save(Resume resume);
    DataResult<Resume> getById(int id);
}
