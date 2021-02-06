package bp.authentication.service;

import bp.authentication.exception.UserNotFoundException;
import bp.authentication.model.User;
import org.springframework.lang.NonNull;

/**
 * UserService interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public interface UserService {
    /**
     * Gets a {@link User} by an id
     *
     * @param userId a user id
     *
     * @return a user if exists
     * @throws UserNotFoundException if user doesn't exist
     */
    @NonNull
    User getUser(@NonNull Long userId) throws UserNotFoundException;
}
