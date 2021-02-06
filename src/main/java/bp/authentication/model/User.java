package bp.authentication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_EMPTY;

/**
 * User class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
@Table(value = "users")
public final class User {
    /**
     * Id
     */
    @Id
    private final Long id;

    /**
     * Username
     */
    @NonNull
    @Embedded(onEmpty = USE_EMPTY)
    private final UserUsername username;

    /**
     * Password
     */
    @NonNull
    @Embedded(onEmpty = USE_EMPTY)
    private final UserPassword password;

    /**
     * User constructor
     *
     * @param id       a user id
     * @param username a user username
     * @param password a user password
     */
    public User(@NonNull Long id, @NonNull UserUsername username, @NonNull UserPassword password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public UserUsername getUsername() {
        return username;
    }

    @NonNull
    public UserPassword getPassword() {
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

        User user = (User) other;
        return user.id.equals(id);
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
