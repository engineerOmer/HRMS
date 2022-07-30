package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.WebsiteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsiteTypeRepository extends JpaRepository<WebsiteType, Integer> {

}