package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.Result;

import java.util.Date;

public interface IdentityValidationService {
    Result checkIdentityNumber(String identityNumber, String firstName, String lastName, Date birthDate);
}
