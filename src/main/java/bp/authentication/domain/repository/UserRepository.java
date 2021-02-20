package bp.authentication.domain.repository;

import bp.authentication.domain.model.user.Email;
import bp.authentication.domain.model.user.Id;
import bp.authentication.domain.model.user.User;
import bp.authentication.domain.model.user.Username;
import org.springframework.data.repository.Repository;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * UserRepository interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public interface UserRepository extends Repository<User, Id> {
    /**
     * Finds a {@link User} by id
     *
     * @param id a user id
     * @return optional of a user
     */
    @NonNull
    Optional<User> findById(@NonNull Id id);

    /**
     * Finds a {@link User} by username
     *
     * @param username a user username
     * @return optional of a user
     */
    @NonNull
    Optional<User> findByUsername(@NonNull Username username);

    /**
     * Finds a {@link User} by email
     *
     * @param email a user email
     * @return optional of a user
     */
    @NonNull
    Optional<User> findByEmail(@NonNull Email email);
}