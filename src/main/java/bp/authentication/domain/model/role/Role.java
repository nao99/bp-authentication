package bp.authentication.domain.model.role;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Role class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-24
 */
@Table(value = "roles")
public class Role {
    /**
     * Id
     */
    @Id
    private final Long id;

    /**
     * Role
     */
    private final String role;

    /**
     * Role constructor
     *
     * @param id   an id
     * @param role a role
     */
    public Role(final Long id, final String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
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
        int hash = 17;

        hash = 31 * hash + id.hashCode();
        hash = 31 * hash + role.hashCode();

        return hash;
    }
}
