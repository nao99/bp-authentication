package org.studyportal.authentication.domain;

import org.studyportal.authentication.domain.model.user.Email;
import org.studyportal.authentication.domain.model.user.User;
import org.studyportal.authentication.domain.model.user.Username;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * GetUserService interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public interface GetUserService extends UserDetailsService {
    /**
     * Gets a {@link User} by username
     *
     * @param username a user username
     *
     * @return a user if it exists
     * @throws UserNotFoundException if user not exists
     */
    User getUserBy(final Username username) throws UserNotFoundException;

    /**
     * Gets a {@link User} by email
     *
     * @param email a user email
     *
     * @return a user if it exists
     * @throws UserNotFoundException if user not exists
     */
    User getUserBy(final Email email) throws UserNotFoundException;
}
