package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.ResumeWebsite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeWebsiteRepository extends JpaRepository<ResumeWebsite, Integer> {
    List<ResumeWebsite> findAllByResumeId(@Param("resumeId") int resumeId);
}