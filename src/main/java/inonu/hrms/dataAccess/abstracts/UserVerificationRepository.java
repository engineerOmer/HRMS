package inonu.hrms.dataAccess.abstracts;

import inonu.hrms.core.dataAccess.abstracts.BaseRepository;
import inonu.hrms.entities.tables.UserVerification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserVerificationRepository extends BaseRepository<UserVerification, Integer> {

    @Query(value = "SELECT CASE WHEN COUNT(uv) > 0 THEN true ELSE false END "
            + "FROM UserVerification uv "
            + "WHERE verificationDate is NOT NULL "
            + "AND userId = :userId")

    boolean userIsVerificated(@Param("userId") int userId);

    UserVerification findByCode(@Param("code") String code);
    boolean existsByCode(@Param("code") String code);

    @Query(value = "SELECT uv.userId FROM UserVerification uv WHERE uv.code = :code")
    int findUserIdByCode(@Param("code") String code);
}