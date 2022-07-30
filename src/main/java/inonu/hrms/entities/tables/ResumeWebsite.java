package inonu.hrms.entities.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "resume_websites")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResumeWebsite {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "resume_website_id")
        private int id;


        @Column(name = "resume_id")
        private int resumeId;


        @Column(name = "website_type_id")
        private int websiteTypeId;


        @Column(name = "website")
        private String website;

        //relation mapping
        @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "resume_id", insertable = false, updatable = false)
        private Resume resume;

        @ManyToOne(targetEntity = WebsiteType.class, fetch = FetchType.LAZY)
        @JsonIgnore
        @JoinColumn(name = "website_type_id", insertable = false, updatable = false)
        private WebsiteType websiteType;
}
