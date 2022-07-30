package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

//ENTITIT KATMANINI VE ID NIN TURUNU VERIP SORGULARI HAZIRLIYORUZ
public interface JobTitleRepository extends JpaRepository<JobTitle,Integer> {
        boolean existsByTitle(@Param("title") String title);
}
