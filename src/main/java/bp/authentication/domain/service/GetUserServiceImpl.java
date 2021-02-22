package bp.authentication.domain.service;

import bp.authentication.domain.exception.UserNotFoundException;
import bp.authentication.domain.model.user.Email;
import bp.authentication.domain.model.user.User;
import bp.authentication.domain.model.user.Username;
import bp.authentication.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * GetUserService class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-06
 */
@Service
public class GetUserServiceImpl implements GetUserService {
    /**
     * User repository
     */
    private final UserRepository repository;

    /**
     * GetUserService constructor
     *
     * @param repository a user repository
     */
    @Autowired
    public GetUserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserBy(Username username) throws UserNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("User with \"%s\" username not found", username));
        }

        return user.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserBy(Email email) throws UserNotFoundException {
        Optional<User> user = repository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("User with \"%s\" email not found", email));
        }

        return user.get();
    }
}
