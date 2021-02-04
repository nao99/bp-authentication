package bp.authentication.model;

import org.springframework.lang.NonNull;

/**
 * User class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public final class User {
    /**
     * Id
     */
    @NonNull
    private final UserId id;

    /**
     * Username
     */
    @NonNull
    private final UserUsername username;

    /**
     * Password
     */
    @NonNull
    private final UserPassword password;

    /**
     * User constructor
     *
     * @param id       a user id
     * @param username a user username
     * @param password a user password
     */
    public User(@NonNull UserId id, @NonNull UserUsername username, @NonNull UserPassword password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @NonNull
    public UserId getId() {
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
