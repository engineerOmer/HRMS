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
@Table(name = "qualifications")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Qualification extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "qualification_id")
        private int id;


        @Column(name = "name", unique = true)
        private String name;

        //relation mapping.
        @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "created_user_id", insertable = false, updatable = false)
        private User createdUser;

        @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "modified_user_id", insertable = false, updatable = false)
        private User modifiedUser;
}
