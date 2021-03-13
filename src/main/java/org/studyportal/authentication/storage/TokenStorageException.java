package org.studyportal.authentication.storage;

/**
 * TokenStorageException class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-25
 */
public class TokenStorageException extends Exception {
    /**
     * TokenStorageException constructor
     *
     * @param message an exception message
     */
    public TokenStorageException(final String message) {
        super(message);
    }

    /**
     * TokenStorageException constructor
     *
     * @param message  an exception message
     * @param previous a previous exception
     */
    public TokenStorageException(final String message, final Throwable previous) {
        super(message, previous);
    }
}
