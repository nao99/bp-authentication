package org.studyportal.authentication.security;

import org.apache.commons.lang3.RandomStringUtils;
import org.studyportal.authentication.domain.model.user.UserDetailed;
import org.studyportal.authentication.storage.TokenStorage;
import org.studyportal.authentication.storage.TokenStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UserLoginSuccessHandler class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-25
 */
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
    private final static int COOKIE_TOKEN_ID_LENGTH = 24;

    /**
     * Token storage
     */
    private final TokenStorage tokenStorage;

    /**
     * Client cookies properties
     */
    private final ClientCookieProperties properties;

    /**
     * UserLoginSuccessHandler constructor
     *
     * @param tokenStorage a token storage
     * @param properties   client cookie properties
     */
    @Autowired
    public UserLoginSuccessHandler(final TokenStorage tokenStorage, final ClientCookieProperties properties) {
        this.tokenStorage = tokenStorage;
        this.properties = properties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAuthenticationSuccess(
        final HttpServletRequest request,
        final HttpServletResponse response,
        final Authentication authentication
    ) {
        UserDetailed user = (UserDetailed) authentication.getPrincipal();

        String tokenId = RandomStringUtils.randomAlphanumeric(COOKIE_TOKEN_ID_LENGTH);
        String tokenValue = user.getUsername();

        try {
            tokenStorage.storeToken(tokenId, tokenValue);
        } catch (TokenStorageException e) {
            return;
        }

        Cookie cookie = new Cookie(properties.getName(), tokenId);

        cookie.setMaxAge((int) properties.getTtl().toSeconds());
        cookie.setSecure(properties.isSecure());
        cookie.setHttpOnly(properties.isHttpOnly());

        response.addCookie(cookie);
    }
}
