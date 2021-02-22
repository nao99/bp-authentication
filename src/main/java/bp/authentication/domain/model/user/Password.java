package bp.authentication.domain.model.user;

/**
 * Password class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public final class Password {
    public final static int PASSWORD_LENGTH_MIN = 8;
    public final static int PASSWORD_LENGTH_MAX = 32;

    // at least one uppercase letter, one lowercase letter, one number and one special character
    private final static String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    /**
     * Password
     */
    private final String password;

    /**
     * Password constructor
     *
     * @param password a password
     * @throws IllegalArgumentException if password is nullable, invalid, less or greater in length than limits
     */
    public Password(String password) {
        if (null == password) {
            throw new IllegalArgumentException("Password cannot be nullable");
        }

        if (PASSWORD_LENGTH_MIN > password.length()) {
            String errorMessage = String.format("Password length cannot be less than %d symbols", PASSWORD_LENGTH_MIN);
            throw new IllegalArgumentException(errorMessage);
        }

        if (PASSWORD_LENGTH_MAX < password.length()) {
            String errorMessagePattern = "Password length cannot be greater than %d symbols";
            String errorMessage = String.format(errorMessagePattern, PASSWORD_LENGTH_MAX);

            throw new IllegalArgumentException(errorMessage);
        }

        if (!password.matches(PASSWORD_REGEX)) {
            throw new IllegalArgumentException("Password is not valid");
        }

        this.password = password;
    }

    public String password() {
        return password;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return password;
    }
}
