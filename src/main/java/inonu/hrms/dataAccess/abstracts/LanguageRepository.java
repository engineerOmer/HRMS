package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
        List<Language> findFirst10ByNameContainingIgnoreCase(@Param("name") String name);
}
