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
@Table(name = "resume_experiences")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResumeExperience {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "resume_experience_id")
        private int id;


        @Column(name = "resume_id")
        private int resumeId;


        @Column(name = "company_name")
        private String companyName;


        @Column(name = "job_title_id")
        private int jobTitleId;


        @Column(name = "start_date")
        private Date startDate;


        @Column(name = "is_continued")
        private boolean continued;

        @Column(name = "end_date")
        private Date endDate;

        //relation mapping.
        @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "resume_id", insertable = false, updatable = false)
        private Resume resume;

        @ManyToOne(targetEntity = JobTitle.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "job_title_id", insertable = false, updatable = false)
        private JobTitle jobTitle;
}
