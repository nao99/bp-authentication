package bp.authentication.domain.repository;

import bp.authentication.domain.model.role.Role;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * RoleRepository interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-24
 */
public interface RoleRepository extends Repository<Role, Long> {
    /**
     * Finds {@link Role}s by user id
     *
     * @param userId a user id
     * @return list of roles
     */
    @Query(
        value = "SELECT " +
                    "role.id AS id, " +
                    "role.role AS role " +
                "FROM roles role " +
                "INNER JOIN user_roles user_role " +
                    "ON user_role.user_id = :userId;"
    )
    List<Role> findByUserId(final Long userId);
}
