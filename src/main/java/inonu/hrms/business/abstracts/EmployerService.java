package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.entities.tables.Employer;

import java.util.List;

public interface EmployerService {
     DataResult<List<Employer>> getAll();
     DataResult<Employer> save(Employer employer);
}
