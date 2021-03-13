package org.studyportal.authentication.domain;

import org.studyportal.authentication.domain.model.user.Email;
import org.studyportal.authentication.domain.model.user.User;
import org.studyportal.authentication.domain.model.user.Username;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * UserRepository interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public interface UserRepository extends Repository<User, Long> {
    /**
     * Finds a {@link User} by username
     *
     * @param username a user username
     * @return optional of a user
     */
    Optional<User> findByUsername(final Username username);

    /**
     * Finds a {@link User} by email
     *
     * @param email a user email
     * @return optional of a user
     */
    Optional<User> findByEmail(final Email email);
}
