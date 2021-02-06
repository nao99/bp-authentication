package bp.authentication.repository;

import bp.authentication.model.User;
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
public interface UserRepository extends Repository<User, Long> {
    /**
     * Finds a {@link User} by an id
     *
     * @param id a user id
     * @return optional of a user
     */
    @NonNull
    Optional<User> findById(@NonNull Long id);
}
