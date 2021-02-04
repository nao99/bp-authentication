package bp.authentication.model;

import org.springframework.lang.NonNull;

/**
 * UserPassword class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public final class UserPassword {
    /**
     * Password
     */
    @NonNull
    private final String password;

    /**
     * UserPassword constructor
     *
     * @param password a user password
     */
    public UserPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@NonNull Object other) {
        if (!other.getClass().isAssignableFrom(UserPassword.class)) {
            return false;
        }

        UserPassword userPassword = (UserPassword) other;
        return userPassword.password.equals(password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 17 + 31 * 17 + password.hashCode();
    }
}
