package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.entities.tables.UserConfirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserConfirmRepository extends JpaRepository<UserConfirm, Integer> {


    @Query(value = "select case when count(uc) > 0 then true else false end "
                    +"from UserConfirm uc "
                    +"where confirmed = true "
                    +"and userId = :userId")
    boolean isConfirmed(@Param("userId") int userId);
}
