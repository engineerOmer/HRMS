package inonu.hrms.entities.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import inonu.hrms.core.entities.BaseEntity;
import inonu.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Country extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "iso")
    private String iso;


    @Column(name = "phone_code")
    private String phoneCode;

    @Column(name = "currency_code")
    private String currencyCode;

    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "created_user_id",insertable = false,updatable = false)
    private User createdUser;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "modified_user_id", insertable = false, updatable = false)
    private User modifiedUser;

}
