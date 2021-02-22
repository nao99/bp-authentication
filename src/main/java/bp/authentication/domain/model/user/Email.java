package bp.authentication.domain.model.user;

/**
 * Email class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-20
 */
public final class Email {
    public final static int EMAIL_LENGTH_MIN = 7;
    public final static int EMAIL_LENGTH_MAX = 48;

    private final static String EMAIL_REGEX = ".+@.+\\..+";

    /**
     * Email
     */
    private final String email;

    /**
     * Email constructor
     *
     * @param email an email
     * @throws IllegalArgumentException if email is nullable, invalid, less or greater in length than limits
     */
    public Email(String email) {
        if (null == email) {
            throw new IllegalArgumentException("Email cannot be nullable");
        }

        if (EMAIL_LENGTH_MIN > email.length()) {
            String errorMessage = String.format("Email length cannot be less than %d symbols", EMAIL_LENGTH_MIN);
            throw new IllegalArgumentException(errorMessage);
        }

        if (EMAIL_LENGTH_MAX < email.length()) {
            String errorMessage = String.format("Email length cannot be greater than %d symbols", EMAIL_LENGTH_MAX);
            throw new IllegalArgumentException(errorMessage);
        }

        if (!email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Email is not valid");
        }

        this.email = email;
    }

    public String email() {
        return email;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!other.getClass().isAssignableFrom(Email.class)) {
            return false;
        }

        Email otherEmail = (Email) other;

        return otherEmail.email.equals(email);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 17 + 31 * 17 + email.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return email;
    }
}
