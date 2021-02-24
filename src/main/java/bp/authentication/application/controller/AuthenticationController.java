package bp.authentication.application.controller;

import bp.authentication.application.model.UserDto;
import bp.authentication.domain.exception.UserNotFoundException;
import bp.authentication.domain.model.role.Role;
import bp.authentication.domain.model.user.Email;
import bp.authentication.domain.model.user.User;
import bp.authentication.domain.model.user.Username;
import bp.authentication.domain.service.GetUserRolesService;
import bp.authentication.domain.service.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
     * Get user service
     */
    private final GetUserService getUserService;

    /**
     * Get user roles service
     */
    private final GetUserRolesService getUserRolesService;

    /**
     * AuthenticationController constructor
     *
     * @param getUserService      a get user service
     * @param getUserRolesService a get user roles service
     */
    @Autowired
    public AuthenticationController(
        final GetUserService getUserService,
        final GetUserRolesService getUserRolesService
    ) {
        this.getUserService = getUserService;
        this.getUserRolesService = getUserRolesService;
    }

    /**
     * API endpoint to get an authenticated {@link User}
     *
     * @param identification a user identification
     * @return a user if exists and authenticated
     */
    @GetMapping(name = "api_v1.0_authentication_get", path = "/{identification:\\w+}")
    public ResponseEntity<UserDto> getAuthenticatedUser(@PathVariable(value = "identification") String identification) {
        Username username = null;
        Email email = null;

        try {
            username = new Username(identification);
        } catch (IllegalArgumentException e) {
            // ignore
        }

        try {
            email = new Email(identification);
        } catch (IllegalArgumentException e) {
            // ignore
        }

        if (null == username && null == email) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User identification is non correct");
        }

        User user;
        try {
            user = null != username
                ? getUserService.getUserBy(username)
                : getUserService.getUserBy(email);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }

        List<Role> roles = getUserRolesService.getRolesBy(user.getId());

        return ResponseEntity.ok(new UserDto(user, roles));
    }
}
