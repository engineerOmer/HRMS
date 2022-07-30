package inonu.hrms.entities.dtos;

import inonu.hrms.entities.tables.UserConfirm;
import inonu.hrms.entities.tables.UserVerification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerLatestVerificationAndConfirm {

        private int id;
        private UserVerification userVerification;
        private UserConfirm userConfirm;
}
