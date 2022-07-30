package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.entities.tables.UserVerification;

public interface UserVerificationService {
        DataResult<UserVerification> generate(int userId);
        abstract DataResult<UserVerification> verificate(String code);
}
