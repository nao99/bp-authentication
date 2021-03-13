package org.studyportal.authentication.storage;

/**
 * TokenOverrideException class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-26
 */
public class TokenOverrideException extends TokenStorageException {
    /**
     * TokenOverrideException constructor
     *
     * @param message an exception message
     */
    public TokenOverrideException(final String message) {
        super(message);
    }

    /**
     * TokenOverrideException constructor
     *
     * @param message  an exception message
     * @param previous a previous exception
     */
    public TokenOverrideException(final String message, final Throwable previous) {
        super(message, previous);
    }
}
