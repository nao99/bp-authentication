package bp.authentication.domain.service;

import bp.authentication.domain.model.user.User;

/**
 * CheckUserAuthenticatedStateService interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-22
 */
public interface CheckUserAuthenticatedStateService {
    /**
     * Checks if a {@link User} is authenticated
     *
     * @param user a user
     * @return user authentication state
     */
    boolean authenticated(User user);
}
