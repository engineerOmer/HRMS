package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.ResumeExperience;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeExperienceRepository extends JpaRepository<ResumeExperience, Integer> {
    List<ResumeExperience> findAllByResumeId(@Param("resumeId") int resumeId);
    List<ResumeExperience> findAllByResumeId(@Param("resumeId") int resumeId, Sort sort);
}
