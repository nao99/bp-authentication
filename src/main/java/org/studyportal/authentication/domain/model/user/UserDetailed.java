package org.studyportal.authentication.domain.model.user;

import org.studyportal.authentication.domain.model.role.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserDetailed class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-25
 */
public class UserDetailed implements UserDetails {
    /**
     * User
     */
    private final User user;

    /**
     * User roles
     */
    private final List<Role> roles;

    /**
     * UserDetailed constructor
     *
     * @param user  a user
     * @param roles user roles
     */
    public UserDetailed(final User user, final List<Role> roles) {
        this.user = user;
        this.roles = roles;
    }

    public Long getId() {
        return user.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPassword() {
        return user.getPassword().password();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return user.getUsername().username();
    }

    public String getEmail() {
        return user.getEmail().email();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles
            .stream()
            .map(role -> new Authority(role.getPrefixedRole()))
            .collect(Collectors.toList());
    }

    /**
     * Authority class
     *
     * @author  Nikolai Osipov <nao99.dev@gmail.com>
     * @version 1.0.0
     * @since   2021-02-25
     */
    private static class Authority implements GrantedAuthority {
        /**
         * Role
         */
        private final String role;

        /**
         * Authority constructor
         *
         * @param role a role
         */
        private Authority(final String role) {
            this.role = role;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getAuthority() {
            return role;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(final Object other) {
            if (!other.getClass().isAssignableFrom(Authority.class)) {
                return false;
            }

            Authority otherAuthority = (Authority) other;

            return otherAuthority.role.equals(role);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return 17 + 31 * 17 + role.hashCode();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return role;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object other) {
        if (!other.getClass().isAssignableFrom(UserDetailed.class)) {
            return false;
        }

        UserDetailed otherUser = (UserDetailed) other;

        return otherUser.user.equals(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 17;

        hash = 31 * hash + user.hashCode();
        hash = 31 * hash + roles.hashCode();

        return hash;
    }
}
