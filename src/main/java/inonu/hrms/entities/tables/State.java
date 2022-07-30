package inonu.hrms.entities.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import inonu.hrms.core.entities.BaseEntity;
import inonu.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "states")
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class State extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private int id;

    @Column(name = "country_id")
    private int countryId;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    //relations mapping.
    @ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "country_id" , insertable = false, updatable = false)
    private Country country;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "created_user_id", insertable = false, updatable = false)
    private User createdUser;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "modified_user_id", insertable = false, updatable = false)
    private User modifiedUser;

}
