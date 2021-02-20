package bp.authentication.domain.service;

import bp.authentication.domain.exception.UserNotFoundException;
import bp.authentication.domain.model.user.Email;
import bp.authentication.domain.model.user.Identity;
import bp.authentication.domain.model.user.User;
import bp.authentication.domain.model.user.Username;
import bp.authentication.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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
    @NonNull
    private final UserRepository repository;

    /**
     * GetUserService constructor
     *
     * @param repository a user repository
     */
    @Autowired
    public GetUserServiceImpl(@NonNull UserRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public User getUserBy(@NonNull Identity identity) throws UserNotFoundException {
        boolean searchByUsername = identity instanceof Username;
        Optional<User> user = searchByUsername
            ? repository.findByUsername((Username) identity)
            : repository.findByEmail((Email) identity);

        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("User \"%s\" not found", identity));
        }

        return user.get();
    }
}
