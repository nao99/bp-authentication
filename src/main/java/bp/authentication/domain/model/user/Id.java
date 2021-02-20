package bp.authentication.domain.model.user;

import org.springframework.lang.NonNull;

/**
 * Id class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-20
 */
public final class Id {
    /**
     * Id
     */
    @NonNull
    private final Long id;

    /**
     * Id constructor
     *
     * @param id an id
     */
    public Id(@NonNull Long id) {
        this.id = id;
    }

    @NonNull
    public Long id() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@NonNull Object other) {
        if (!other.getClass().isAssignableFrom(Id.class)) {
            return false;
        }

        Id otherId = (Id) other;

        return otherId.id.equals(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 17 + 31 * 17 + id.hashCode();
    }
}
