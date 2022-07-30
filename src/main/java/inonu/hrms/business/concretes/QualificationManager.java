package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.QualificationService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.core.utilities.results.SuccessDataResult;
import inonu.hrms.core.utilities.results.SuccessResult;
import inonu.hrms.dataAccess.abstracts.QualificationRepository;
import inonu.hrms.entities.tables.Qualification;


import java.util.List;

public class QualificationManager implements QualificationService {
    private QualificationRepository qualificationRepository;
    @Override
    public DataResult<List<Qualification>> getAllByName(String name) {
        return new SuccessDataResult<List<Qualification>>(this.qualificationRepository.findFirst10ByNameContainingIgnoreCase(name));
    }

    @Override
    public Result save(Qualification qualification) {
        this.qualificationRepository.save(qualification);
        return new SuccessResult();
    }
}
