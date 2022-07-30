package inonu.hrms.entities.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import inonu.hrms.business.constants.ValidationMessages;
import inonu.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Entity
@Table(name = "user_confirms")
@AllArgsConstructor
@NoArgsConstructor
public class UserConfirm {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_confirm_id")
        private int id;

        @NotNull(message = ValidationMessages.NOT_BLANK)
        @Column(name = "user_id")
        private int userId;


        @NotNull(message = ValidationMessages.NOT_BLANK)
        @Column(name = "is_confirmed")
        private boolean confirmed;

        @NotNull(message = ValidationMessages.NOT_BLANK)
        @Column(name = "confirmed_user_id")
        private int confirmedUserId;

        @NotNull(message = ValidationMessages.NOT_BLANK)
        @Column(name = "confirmed_date")
        private Instant confirmedDate;

        //relation mapping
        @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "user_id", insertable = false, updatable = false)
        private User user;

        @ManyToOne(targetEntity = Employee.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "confirmed_user_id", insertable = false, updatable = false)
        private Employee confirmedUser;
}
