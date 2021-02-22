package bp.authentication.domain.service;

import bp.authentication.domain.exception.UserNotFoundException;
import bp.authentication.domain.model.user.Email;
import bp.authentication.domain.model.user.User;
import bp.authentication.domain.model.user.Username;

/**
 * GetUserService interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public interface GetUserService {
    /**
     * Gets a {@link User} by username
     *
     * @param username a user username
     *
     * @return a user if exists
     * @throws UserNotFoundException if user doesn't exist
     */
    User getUserBy(Username username) throws UserNotFoundException;

    /**
     * Gets a {@link User} by email
     *
     * @param email a user email
     *
     * @return a user if exists
     * @throws UserNotFoundException if user doesn't exist
     */
    User getUserBy(Email email) throws UserNotFoundException;
}
