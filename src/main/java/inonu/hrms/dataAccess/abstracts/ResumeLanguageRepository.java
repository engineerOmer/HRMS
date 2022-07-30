package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.ResumeLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeLanguageRepository extends JpaRepository<ResumeLanguage, Integer> {
    List<ResumeLanguage> findAllByResumeId(@Param("resumeId") int resumeId);
}