package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.Result;

public interface EmployerConfirmService {
    Result confirm(int userId, int confirmerUserId);
}
