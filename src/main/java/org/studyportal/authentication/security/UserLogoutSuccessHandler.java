package org.studyportal.authentication.security;

import org.studyportal.authentication.storage.TokenStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

/**
 * UserLogoutSuccessHandler class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-25
 */
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    /**
     * Token storage
     */
    private final TokenStorage tokenStorage;

    /**
     * Client cookies properties
     */
    private final ClientCookieProperties properties;

    /**
     * UserLogoutSuccessHandler constructor
     *
     * @param tokenStorage a token storage
     * @param properties   client cookie properties
     */
    @Autowired
    public UserLogoutSuccessHandler(final TokenStorage tokenStorage, final ClientCookieProperties properties) {
        this.tokenStorage = tokenStorage;
        this.properties = properties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onLogoutSuccess(
        final HttpServletRequest request,
        final HttpServletResponse response,
        final Authentication authentication
    ) {
        Cookie[] cookie = request.getCookies();
        Optional<Cookie> authCookieOptional = Arrays
            .stream(cookie)
            .filter(c -> properties.getName().equals(c.getName()))
            .findFirst();

        if (authCookieOptional.isEmpty()) {
            return;
        }

        Cookie authCookie = authCookieOptional.get();
        String tokenId = authCookie.getValue();

        tokenStorage.removeToken(tokenId);

        authCookie.setValue(null);
        authCookie.setMaxAge(-1);

        response.addCookie(authCookie);
    }
}
