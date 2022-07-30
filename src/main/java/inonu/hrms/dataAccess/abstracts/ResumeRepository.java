package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Integer> {

}