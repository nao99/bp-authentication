package bp.authentication.domain.model.user;

import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

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
     * User constructor
     *
     * @param username a user username
     * @param email    a user email
     * @param password a user password
     */
    public User(@NonNull Username username, @NonNull Email email, @NonNull Password password) {
        this.username = username;
        this.email = email;
        this.password = password;
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

        hash = 31 * hash + username.hashCode();
        hash = 31 * hash + email.hashCode();
        hash = 31 * hash + password.hashCode();

        return hash;
    }
}
