package inonu.hrms.entities.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import inonu.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "resume_languages")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResumeLanguage {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "resume_language_id")
        private int id;

        @CreatedDate
        @JsonIgnore
        @Column(name = "created_date", updatable = false)
        private Instant createdDate = Instant.now();

        @LastModifiedDate
        @JsonIgnore
        @Column(name = "modified_date")
        private Instant modifiedDate = Instant.now();


        @Column(name = "resume_id")
        private int resumeId;


        @Column(name = "language_id")
        private int languageId;


        @Size(min = 1, max = 5, message = ValidationMessages.GRADE_MUST_BE_BETWEEN)
        @Column(name = "grade")
        private BigDecimal grade;

        //relation mapping
        @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "resume_id", insertable = false, updatable = false)
        private Resume resume;

        @ManyToOne(targetEntity = Language.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "language_id", insertable = false, updatable = false)
        private Language language;
}
