package bp.authentication.domain.model.user;

import org.springframework.lang.NonNull;

/**
 * Username class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public final class Username implements Identity {
    /**
     * Username
     */
    @NonNull
    private final String username;

    /**
     * Username constructor
     *
     * @param username a username
     */
    public Username(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String username() {
        return username;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@NonNull Object other) {
        if (!other.getClass().isAssignableFrom(Username.class)) {
            return false;
        }

        Username otherUsername = (Username) other;

        return otherUsername.username.equals(username);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 17 + 31 * 17 + username.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public String toString() {
        return username;
    }
}
