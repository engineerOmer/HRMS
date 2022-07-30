package inonu.hrms.entities.tables;


import inonu.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="user_id")
public class Candidate extends User {


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name ="identity_number")
    private String identityNumber;


    @Column(name="birth_date")
    private java.sql.Date birthDate;

}
