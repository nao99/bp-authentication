package bp.authentication.domain.model.user;

import org.springframework.lang.NonNull;

/**
 * Email class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-20
 */
public final class Email implements Identity {
    /**
     * Email
     */
    @NonNull
    private final String email;

    /**
     * Email constructor
     *
     * @param email an email
     */
    public Email(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String email() {
        return email;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@NonNull Object other) {
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
    @NonNull
    @Override
    public String toString() {
        return email;
    }
}
