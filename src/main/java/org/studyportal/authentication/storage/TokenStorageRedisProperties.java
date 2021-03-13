package org.studyportal.authentication.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * TokenStorageRedisProperties class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-25
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "storage.redis")
public class TokenStorageRedisProperties {
    /**
     * Key prefix for shared environments
     */
    private final String prefix;

    /**
     * Time to live of a token in seconds
     */
    @DurationUnit(value = ChronoUnit.SECONDS)
    private final Duration ttl;

    /**
     * TokenStorageRedisProperties constructor
     *
     * @param prefix a prefix
     * @param ttl    a ttl
     */
    public TokenStorageRedisProperties(final String prefix, final Duration ttl) {
        this.prefix = prefix;
        this.ttl = ttl;
    }

    public String getPrefix() {
        return prefix;
    }

    public Duration getTtl() {
        return ttl;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!other.getClass().isAssignableFrom(TokenStorageRedisProperties.class)) {
            return false;
        }

        TokenStorageRedisProperties otherProperties = (TokenStorageRedisProperties) other;

        return otherProperties.prefix.equals(prefix)
            && otherProperties.ttl.equals(ttl);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 17;

        hash = 31 * hash + prefix.hashCode();
        hash = 31 * hash + ttl.hashCode();

        return hash;
    }
}
