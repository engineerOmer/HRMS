package inonu.hrms.entities.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import inonu.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "resume_qualifications")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResumeQualification {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "resume_qualification_id")
        private int id;


        @Column(name = "resume_id")
        private int resumeId;


        @Column(name = "qualification_id")
        private int qualificationId;



        @Size(min = 1, max = 5, message = ValidationMessages.GRADE_MUST_BE_BETWEEN)
        @Column(name = "grade")
        private BigDecimal grade;

        //relation mapping
        @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "resume_id", insertable = false, updatable = false)
        private Resume resume;

        @ManyToOne(targetEntity = Qualification.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "qualification_id", insertable = false, updatable = false)
        private Qualification qualification;
}
