package inonu.hrms.entities.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "resume_educations")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResumeEducation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "resume_education_id")
        private int id;


        @Column(name = "resume_id")
        private int resumeId;


        @Column(name = "school_name")
        private String schoolName;


        @Column(name = "department_name")
        private String departmentName;


        @Column(name = "start_date")
        private Date startDate;


        @Column(name = "is_graduate")
        private boolean graduate;

        @Column(name = "graduate_date")
        private Date graduateDate;

        //relation mapping.
        @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "resume_id", insertable = false, updatable = false)
        private Resume resume;
}
