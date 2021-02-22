package bp.authentication.domain.model.user;

/**
 * Username class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public final class Username {
    public final static int USERNAME_LENGTH_MIN = 2;
    public final static int USERNAME_LENGTH_MAX = 32;

    private final static String USERNAME_REGEX = "[a-z_0-9]+";

    /**
     * Username
     */
    private final String username;

    /**
     * Username constructor
     *
     * @param username a username
     * @throws IllegalArgumentException if username is nullable, invalid, less or greater in length than limits
     */
    public Username(String username) {
        if (null == username) {
            throw new IllegalArgumentException("Username cannot be nullable");
        }

        if (USERNAME_LENGTH_MIN > username.length()) {
            String errorMessage = String.format("Username length cannot be less than %d symbols", USERNAME_LENGTH_MIN);
            throw new IllegalArgumentException(errorMessage);
        }

        if (USERNAME_LENGTH_MAX < username.length()) {
            String errorMessagePattern = "Username length cannot be greater than %d symbols";
            String errorMessage = String.format(errorMessagePattern, USERNAME_LENGTH_MAX);

            throw new IllegalArgumentException(errorMessage);
        }

        if (!username.matches(USERNAME_REGEX)) {
            throw new IllegalArgumentException("Username is not valid");
        }

        this.username = username;
    }

    public String username() {
        return username;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
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
    @Override
    public String toString() {
        return username;
    }
}
