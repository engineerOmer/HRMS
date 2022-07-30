package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.ResumeEducation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeEducationRepository extends JpaRepository<ResumeEducation, Integer> {
    List<ResumeEducation> findAllByResumeId(@Param("id") int id);
    List<ResumeEducation> findAllByResumeId(@Param("id") int id, Sort sort);

}