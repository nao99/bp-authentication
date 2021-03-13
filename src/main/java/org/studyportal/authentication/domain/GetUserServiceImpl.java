package org.studyportal.authentication.domain;

import org.studyportal.authentication.domain.model.role.Role;
import org.studyportal.authentication.domain.model.user.Email;
import org.studyportal.authentication.domain.model.user.User;
import org.studyportal.authentication.domain.model.user.UserDetailed;
import org.studyportal.authentication.domain.model.user.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * GetUserServiceImpl class
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
    private final UserRepository userRepository;

    /**
     * Role repository
     */
    private final RoleRepository roleRepository;

    /**
     * GetUserServiceImpl constructor
     *
     * @param userRepository a user repository
     * @param roleRepository a role repository
     */
    @Autowired
    public GetUserServiceImpl(final UserRepository userRepository, final RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserBy(final Username username) throws UserNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("User with the \"%s\" username not found", username));
        }

        return user.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserBy(final Email email) throws UserNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("User with the \"%s\" email not found", email));
        }

        return user.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        int errorsToInstantiateUsernameCount = 0;

        Username userUsername = null;
        try {
            userUsername = new Username(username);
        } catch (IllegalArgumentException e) {
            errorsToInstantiateUsernameCount++;
        }

        Email userEmail = null;
        try {
            userEmail = new Email(username);
        } catch (IllegalArgumentException e) {
            errorsToInstantiateUsernameCount++;
        }

        if (2 == errorsToInstantiateUsernameCount) {
            throw new IllegalArgumentException(String.format("The \"%s\" username is not valid", username));
        }

        User user = null;
        try {
            if (null != userUsername) {
                user = getUserBy(userUsername);
            }

            if (null != userEmail) {
                user = getUserBy(userEmail);
            }
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage(), e);
        }

        List<Role> roles = roleRepository.findByUserId(user.getId());

        return new UserDetailed(user, roles);
    }
}
