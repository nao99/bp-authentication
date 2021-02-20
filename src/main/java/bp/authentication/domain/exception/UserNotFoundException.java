package bp.authentication.domain.exception;

import org.springframework.lang.NonNull;

/**
 * UserNotFoundException class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-06
 */
public class UserNotFoundException extends Exception {
    /**
     * UserNotFoundException constructor
     */
    public UserNotFoundException() {
        super();
    }

    /**
     * UserNotFoundException constructor
     *
     * @param message an exception message
     */
    public UserNotFoundException(@NonNull String message) {
        super(message);
    }

    /**
     * UserNotFoundException constructor
     *
     * @param message  an exception message
     * @param previous a previous exception
     */
    public UserNotFoundException(@NonNull String message, @NonNull Throwable previous) {
        super(message, previous);
    }
}
