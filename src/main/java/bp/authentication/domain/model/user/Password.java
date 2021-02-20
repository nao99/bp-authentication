package bp.authentication.domain.model.user;

import org.springframework.lang.NonNull;

/**
 * Password class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public final class Password {
    /**
     * Password
     */
    @NonNull
    private final String password;

    /**
     * Password constructor
     *
     * @param password a password
     */
    public Password(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String password() {
        return password;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@NonNull Object other) {
        if (!other.getClass().isAssignableFrom(Password.class)) {
            return false;
        }

        Password otherPassword = (Password) other;

        return otherPassword.password.equals(password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 17 + 31 * 17 + password.hashCode();
    }
}
