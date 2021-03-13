package org.studyportal.authentication.domain.model.user;

/**
 * Password class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public final class SecuredPassword {
    public final static int PASSWORD_LENGTH = 60;

    /**
     * Password
     */
    private final String password;

    /**
     * Password constructor
     *
     * @param password a password
     * @throws IllegalArgumentException if password is nullable, less or greater in length than limit
     */
    public SecuredPassword(final String password) {
        if (null == password) {
            throw new IllegalArgumentException("Password cannot be nullable");
        }

        if (PASSWORD_LENGTH != password.length()) {
            String errorMessage = String.format("Password length must be equal to %d symbols", PASSWORD_LENGTH);
            throw new IllegalArgumentException(errorMessage);
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
        if (!other.getClass().isAssignableFrom(SecuredPassword.class)) {
            return false;
        }

        SecuredPassword otherPassword = (SecuredPassword) other;

        return otherPassword.password.equals(password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 31 * 17 + password.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return password;
    }
}
