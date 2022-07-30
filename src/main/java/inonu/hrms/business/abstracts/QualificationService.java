package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.tables.Qualification;

import java.util.List;

public interface QualificationService {
    DataResult<List<Qualification>> getAllByName(String name);
    Result save(Qualification qualification);
}
