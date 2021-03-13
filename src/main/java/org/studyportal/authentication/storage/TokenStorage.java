package org.studyportal.authentication.storage;

/**
 * TokenStorage interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-25
 */
public interface TokenStorage {
    /**
     * Reads a stored token from storage
     *
     * @param tokenId a token id
     *
     * @return a stored token value
     * @throws TokenNotFoundException if a token not exists
     */
    String getToken(final String tokenId) throws TokenNotFoundException;

    /**
     * Stores a token in storage
     *
     * @param tokenId    a token ID
     * @param tokenValue a token value
     *
     * @throws TokenOverrideException if a token already exists
     * @throws TokenStorageException if something was wrong
     */
    void storeToken(final String tokenId, final String tokenValue) throws TokenStorageException;

    /**
     * Removes a token from storage
     *
     * @param tokenId a token id
     */
    void removeToken(final String tokenId);

    /**
     * Checks if a token does exist in storage
     *
     * @param tokenId a token id
     *
     * @return token existence state
     * @throws TokenStorageException if something was wrong
     */
    boolean hasToken(final String tokenId) throws TokenStorageException;
}
