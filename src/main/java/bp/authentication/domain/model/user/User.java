package bp.authentication.domain.model.user;

import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

import java.util.Set;

/**
 * User class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
@Table(value = "users")
public class User {
    /**
     * Id
     */
    @org.springframework.data.annotation.Id
    @NonNull
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private final Id id;

    /**
     * Username
     */
    @NonNull
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private final Username username;

    /**
     * Email
     */
    @NonNull
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private final Email email;

    /**
     * Password
     */
    @NonNull
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private final Password password;

    /**
     * Roles
     */
    @NonNull
    private final Set<Role> roles;

    /**
     * User constructor
     *
     * @param id       a user id
     * @param username a user username
     * @param email    a user email
     * @param password a user password
     * @param roles    user roles
     */
    public User(
        @NonNull Id id,
        @NonNull Username username,
        @NonNull Email email,
        @NonNull Password password,
        @NonNull Set<Role> roles
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @NonNull
    public Id getId() {
        return id;
    }

    @NonNull
    public Username getUsername() {
        return username;
    }

    @NonNull
    public Email getEmail() {
        return email;
    }

    @NonNull
    public Password getPassword() {
        return password;
    }

    @NonNull
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@NonNull Object other) {
        if (!other.getClass().isAssignableFrom(User.class)) {
            return false;
        }

        User otherUser = (User) other;

        return otherUser.username.equals(username);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 17;

        hash = 31 * hash + id.hashCode();
        hash = 31 * hash + username.hashCode();
        hash = 31 * hash + password.hashCode();

        return hash;
    }
}
