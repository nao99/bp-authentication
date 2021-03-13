package org.studyportal.authentication.controller;

import org.studyportal.authentication.api.model.user.UserDto;
import org.studyportal.authentication.domain.model.user.User;
import org.studyportal.authentication.domain.model.user.UserDetailed;
import org.studyportal.authentication.domain.GetUserService;
import org.studyportal.authentication.storage.TokenNotFoundException;
import org.studyportal.authentication.storage.TokenStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;

/**
 * AuthenticationController class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-24
 */
@RestController
@RequestMapping(name = "api_v1.0_authentication", path = "/api/v1.0/auth")
public class AuthenticationController {
    /**
     * Token storage
     */
    private final TokenStorage tokenStorage;

    /**
     * Get user service
     */
    private final GetUserService getUserService;

    /**
     * AuthenticationController constructor
     *
     * @param tokenStorage   a token storage
     * @param getUserService a get user service
     */
    @Autowired
    public AuthenticationController(final TokenStorage tokenStorage, final GetUserService getUserService) {
        this.tokenStorage = tokenStorage;
        this.getUserService = getUserService;
    }

    /**
     * API endpoint to get an authenticated {@link User}
     *
     * @param cookie a cookie of a potentially authenticated user
     *
     * @return an authenticated user
     * @throws ResponseStatusException with 400, 404 or 422 status code
     *                                 if cookie was not passed in request or user is not authenticated or not found
     */
    @GetMapping(name = "api_v1.0_authentication_get_authenticated_user", path = "/user")
    public ResponseEntity<UserDto> getAuthenticatedUser(@CookieValue(name = "auth") Cookie cookie) {
        if (null == cookie) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to get user without cookies");
        }

        String username;
        try {
            username = tokenStorage.getToken(cookie.getValue());
        } catch (TokenNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "This user is not authenticated", e);
        }

        UserDetailed user;
        try {
            user = (UserDetailed) getUserService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            String exceptionMessage = String.format("User \"%s\" not found", username);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exceptionMessage, e);
        }

        return ResponseEntity.ok(new UserDto(user));
    }
}
