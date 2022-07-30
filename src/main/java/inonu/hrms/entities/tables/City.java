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
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class City extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int id;

    @Column(name = "state_id")
    private int stateId;

    @Column(name = "name")
    private String name;


    //relation mapping.
    @ManyToOne(targetEntity = State.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "state_id" , insertable = false, updatable = false)
    private State country;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "created_user_id", insertable = false, updatable = false)
    private User createdUser;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "modified_user_id", insertable = false, updatable = false)
    private User modifiedUser;
}
