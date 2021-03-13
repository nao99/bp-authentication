package org.studyportal.authentication.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * TokenStorageRedis class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-25
 */
@Service
public class TokenStorageRedis implements TokenStorage {
    /**
     * Redis template
     */
    private final RedisTemplate<String, String> redisTemplate;

    /**
     * Token storage redis properties
     */
    private final TokenStorageRedisProperties properties;

    /**
     * TokenStorageRedis constructor
     *
     * @param redisTemplate a redis template
     * @param properties    token storage redis properties
     */
    @Autowired
    public TokenStorageRedis(
        final RedisTemplate<String, String> redisTemplate,
        final TokenStorageRedisProperties properties
    ) {
        this.redisTemplate = redisTemplate;
        this.properties = properties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getToken(final String tokenId) throws TokenNotFoundException {
        String prefixedTokenId = getPrefixedTokenId(tokenId);
        String tokenValue = redisTemplate
            .opsForValue()
            .get(prefixedTokenId);

        if (null == tokenValue) {
            throw new TokenNotFoundException(String.format("Token with id \"%s\" not found", tokenId));
        }

        return tokenValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void storeToken(final String tokenId, final String tokenValue) throws TokenStorageException {
        String prefixedTokenId = getPrefixedTokenId(tokenId);
        Boolean tokenStored = redisTemplate
            .opsForValue()
            .setIfAbsent(prefixedTokenId, tokenValue, properties.getTtl());

        if (null == tokenStored) {
            String exceptionMessage = "Unable to understand if a token was stored or not. Null value has got";
            throw new TokenStorageException(exceptionMessage);
        }

        if (!tokenStored) {
            throw new TokenOverrideException(String.format("Token with id \"%s\" already exists", tokenId));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeToken(final String tokenId) {
        String prefixedTokenId = getPrefixedTokenId(tokenId);
        redisTemplate.delete(prefixedTokenId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasToken(final String tokenId) throws TokenStorageException {
        String prefixedTokenId = getPrefixedTokenId(tokenId);
        Boolean hasToken = redisTemplate.hasKey(prefixedTokenId);

        if (null == hasToken) {
            String exceptionMessage = "Unable to understand if there is a token in storage or not. Null value has got";
            throw new TokenStorageException(exceptionMessage);
        }

        return hasToken;
    }

    /**
     * Computes a prefixed token id
     *
     * @param tokenId a token id
     * @return a token id with prefix
     */
    private String getPrefixedTokenId(final String tokenId) {
        return String.format("%s%s", properties.getPrefix(), tokenId);
    }
}
