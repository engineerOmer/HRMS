package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.Result;

public interface UserCheckService {
    Result checkIfEmailAlreadyExists(String email,int id);
}
