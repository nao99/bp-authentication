package bp.authentication.domain.service;

import bp.authentication.domain.exception.UserNotFoundException;
import bp.authentication.domain.model.user.Identity;
import bp.authentication.domain.model.user.User;
import org.springframework.lang.NonNull;

/**
 * GetUserService interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public interface GetUserService {
    /**
     * Gets a {@link User} by identity
     *
     * @param identity a user identity
     *
     * @return a user if exists
     * @throws UserNotFoundException if user doesn't exist
     */
    @NonNull
    User getUserBy(@NonNull Identity identity) throws UserNotFoundException;
}
