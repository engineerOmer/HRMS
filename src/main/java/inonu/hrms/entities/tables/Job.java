package inonu.hrms.entities.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import inonu.hrms.core.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "jobs")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Job extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int id;

    @JsonIgnore(false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "created_user_id")
    private int createdUserId;


    @Column(name = "state_id")
    private int stateId;


    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;


    @Column(name = "job_title_id")
    private int jobTitleId;

    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @Column(name = "max_salary")
    private BigDecimal maxSalary;


    @Column(name = "applicant_quota")
    private BigDecimal applicantQuota;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_application_date")
    private Date lastApplicationDate;


    // relation mapping.
    @ManyToOne(targetEntity = State.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "state_id" , insertable = false, updatable = false)
    private State state;

    @ManyToOne(targetEntity = JobTitle.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "job_title_id", insertable = false, updatable = false)
    private JobTitle jobTitle;

    @ManyToOne(targetEntity = Employer.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "created_user_id", insertable = false, updatable = false)
    private Employer createdUser;

    @ManyToOne(targetEntity = Employer.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "modified_user_id", insertable = false, updatable = false)
    private Employer modifiedUser;

}
