package bp.authentication.model;

import org.springframework.lang.NonNull;

/**
 * UserUsername class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public final class UserUsername {
    /**
     * Username
     */
    @NonNull
    private final String username;

    /**
     * UserUsername constructor
     *
     * @param username a user username
     */
    public UserUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@NonNull Object other) {
        if (!other.getClass().isAssignableFrom(UserUsername.class)) {
            return false;
        }

        UserUsername userUsername = (UserUsername) other;
        return userUsername.username.equals(username);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 17 + 31 * 17 + username.hashCode();
    }
}
