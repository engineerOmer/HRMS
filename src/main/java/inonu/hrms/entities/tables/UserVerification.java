package inonu.hrms.entities.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import inonu.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "user_verifications")
@AllArgsConstructor
@NoArgsConstructor
public class UserVerification {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_verification_id")
        private int id;

        @CreatedDate
        @JsonIgnore
        @Column(name = "created_date", updatable = false)
        private Instant createdDate = Instant.now();


        @Column(name = "user_id")
        private int userId;


        @Column(name = "code")
        private String code;


        @Column(name = "expiry_date")
        private Instant expiryDate;



        @Column(name = "verification_date")
        private Instant verificationDate;

        //relation mapping
        @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "user_id", insertable = false, updatable = false)
        private User user;
}
