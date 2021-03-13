package org.studyportal.authentication.api.model.user;

import org.studyportal.authentication.domain.model.user.User;
import org.studyportal.authentication.domain.model.user.UserDetailed;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UserDto class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-26
 */
public class UserDto {
    /**
     * User
     */
    private final UserDetailed user;

    /**
     * UserDto constructor
     *
     * @param user a user
     */
    public UserDto(final UserDetailed user) {
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public List<String> getRoles() {
        return user.getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!other.getClass().isAssignableFrom(User.class)) {
            return false;
        }

        UserDto otherUserDto = (UserDto) other;

        return otherUserDto.user.equals(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 31 * 17 + user.hashCode();
    }
}
