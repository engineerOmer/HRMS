package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QualificationRepository extends JpaRepository<Qualification, Integer> {
        List<Qualification> findFirst10ByNameContainingIgnoreCase(@Param("name") String name);
}
