package inonu.hrms.business.abstracts;


import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.tables.Candidate;

import java.util.List;

public interface CandidateService {
    DataResult<Candidate> save(Candidate candidate);
    DataResult<List<Candidate>> getAll();
}
