package org.studyportal.authentication.storage;

/**
 * TokenNotFoundException class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-25
 */
public class TokenNotFoundException extends TokenStorageException {
    /**
     * TokenNotFoundException constructor
     *
     * @param message an exception message
     */
    public TokenNotFoundException(final String message) {
        super(message);
    }

    /**
     * TokenNotFoundException constructor
     *
     * @param message  an exception message
     * @param previous a previous exception
     */
    public TokenNotFoundException(final String message, final Throwable previous) {
        super(message, previous);
    }
}
