package org.studyportal.authentication.domain.model.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

/**
 * User class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
@Table(value = "users")
public class User {
    /**
     * Id
     */
    @Id
    private final Long id;

    /**
     * Username
     */
    @Embedded.Nullable
    private final Username username;

    /**
     * Email
     */
    @Embedded.Nullable
    private final Email email;

    /**
     * Password
     */
    @Embedded.Nullable
    private final SecuredPassword password;

    /**
     * User constructor
     *
     * @param id       an id
     * @param username a username
     * @param email    an email
     * @param password a password
     */
    public User(final Long id, final Username username, final Email email, final SecuredPassword password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Username getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }

    public SecuredPassword getPassword() {
        return password;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!other.getClass().isAssignableFrom(User.class)) {
            return false;
        }

        User otherUser = (User) other;

        return otherUser.username.equals(username);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 17;

        hash = 31 * hash + id.hashCode();
        hash = 31 * hash + username.hashCode();
        hash = 31 * hash + email.hashCode();
        hash = 31 * hash + password.hashCode();

        return hash;
    }
}
