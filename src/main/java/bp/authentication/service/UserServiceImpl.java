package bp.authentication.service;

import bp.authentication.exception.UserNotFoundException;
import bp.authentication.model.User;
import bp.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * UserServiceImpl class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-06
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * User repository
     */
    private final UserRepository repository;

    /**
     * UserServiceImpl constructor
     *
     * @param repository a user repository
     */
    @Autowired
    public UserServiceImpl(@NonNull UserRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public User getUser(@NonNull Long userId) throws UserNotFoundException {
        Optional<User> user = repository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("User with \"%d\" id not found", userId));
        }

        return user.get();
    }
}
