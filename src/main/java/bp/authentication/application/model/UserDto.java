package bp.authentication.application.model;

import bp.authentication.domain.model.role.Role;
import bp.authentication.domain.model.user.Email;
import bp.authentication.domain.model.user.User;
import bp.authentication.domain.model.user.Username;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UserDto class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-24
 */
public class UserDto {
    /**
     * Username
     */
    private final Username username;

    /**
     * Email
     */
    private final Email email;

    /**
     * Roles
     */
    private final List<Role> roles;

    /**
     * UserDto constructor
     *
     * @param user  a user
     * @param roles roles
     */
    public UserDto(final User user, final List<Role> roles) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.roles = roles;
    }

    public String getUsername() {
        return username.username();
    }

    public String getEmail() {
        return email.email();
    }

    public List<String> getRoles() {
        return roles.stream()
            .map(role -> "ROLE_" + role.getRole())
            .collect(Collectors.toList());
    }
}
