package inonu.hrms.entities.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import inonu.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "website_types")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WebsiteType {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "website_type_id")
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
