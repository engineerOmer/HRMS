package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.ResumeQualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeQualificationRepository extends JpaRepository<ResumeQualification, Integer> {
    List<ResumeQualification> findAllByResumeId(@Param("resumeId") int resumeId);
}