package bp.authentication.model;

import org.springframework.lang.NonNull;

/**
 * UserId class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
public final class UserId {
    /**
     * Id
     */
    private final long id;

    /**
     * UserId constructor
     *
     * @param id a user id
     */
    public UserId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@NonNull Object other) {
        if (!other.getClass().isAssignableFrom(UserId.class)) {
            return false;
        }

        UserId userId = (UserId) other;
        return userId.id == id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return (int) (17 + 31 * 17 + id);
    }
}
