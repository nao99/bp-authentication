package org.studyportal.authentication.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * ClientCookieProperties class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-26
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "security.client.cookies")
public class ClientCookieProperties {
    /**
     * Cookie name
     */
    private final String name;

    /**
     * Time of expiration in seconds
     */
    @DurationUnit(value = ChronoUnit.SECONDS)
    private final Duration ttl;

    /**
     * Secure flag
     */
    private final boolean secure;

    /**
     * Http only flag
     */
    private final boolean httpOnly;

    /**
     * ClientCookieProperties constructor
     *
     * @param name     a name
     * @param ttl      a ttl
     * @param secure   a secure flag
     * @param httpOnly an http only flag
     */
    public ClientCookieProperties(
        final String name,
        final Duration ttl,
        final boolean secure,
        final boolean httpOnly
    ) {
        this.name = name;
        this.ttl = ttl;
        this.secure = secure;
        this.httpOnly = httpOnly;
    }

    public String getName() {
        return name;
    }

    public Duration getTtl() {
        return ttl;
    }

    public boolean isSecure() {
        return secure;
    }

    public boolean isHttpOnly() {
        return httpOnly;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!other.getClass().isAssignableFrom(ClientCookieProperties.class)) {
            return false;
        }

        ClientCookieProperties otherCookies = (ClientCookieProperties) other;

        return otherCookies.name.equals(name)
            && otherCookies.ttl.equals(ttl)
            && otherCookies.secure == secure
            && otherCookies.httpOnly == httpOnly;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 17;

        hash = 31 * hash + name.hashCode();
        hash = 31 * hash + ttl.hashCode();
        hash = 31 * hash + (secure ? 1 : 0);
        hash = 31 * hash + (httpOnly ? 1 : 0);

        return hash;
    }
}
