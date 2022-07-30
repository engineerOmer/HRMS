package inonu.hrms.core.dataAccess.abstracts;

import inonu.hrms.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmailAndIdNot(@Param("email") String email, @Param("id") int id);
}
