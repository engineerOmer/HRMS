package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
        boolean existsByIdentityNumberAndIdNot(@Param("identityNumber") String identityNumber, @Param("id") int id);
}
