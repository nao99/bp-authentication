package bp.authentication.domain.service;

import bp.authentication.domain.model.role.Role;

import java.util.List;

/**
 * GetUserRolesService interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-24
 */
public interface GetUserRolesService {
    /**
     * Gets {@link Role}s by user id
     *
     * @param userId a user id
     * @return list of roles
     */
    List<Role> getRolesBy(final Long userId);
}
