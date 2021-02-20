package bp.authentication.domain.model.user;

import org.springframework.lang.NonNull;

/**
 * Role class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-20
 */
public final class Role {
    /**
     * Role
     */
    @NonNull
    private final String role;

    /**
     * Role constructor
     *
     * @param role a user role
     */
    public Role(@NonNull String role) {
        this.role = role;
    }

    @NonNull
    public String role() {
        return role;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@NonNull Object other) {
        if (!other.getClass().isAssignableFrom(Role.class)) {
            return false;
        }

        Role otherRole = (Role) other;

        return otherRole.role.equals(role);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 17 + 31 * 17 + role.hashCode();
    }
}
