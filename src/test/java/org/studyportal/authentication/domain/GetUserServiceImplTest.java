package org.studyportal.authentication.domain;

import org.studyportal.authentication.domain.model.user.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * GetUserServiceImplTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-06
 */
@ExtendWith(SpringExtension.class)
public class GetUserServiceImplTest {
    /**
     * User repository mock
     */
    @MockBean
    private UserRepository userRepositoryMock;

    /**
     * Role repository mock
     */
    @MockBean
    private RoleRepository roleRepositoryMock;

    /**
     * User service
     */
    private GetUserServiceImpl service;

    /**
     * Sets up
     */
    @BeforeEach
    public void setUp() throws Exception {
        service = new GetUserServiceImpl(userRepositoryMock, roleRepositoryMock);
    }

    /**
     * Test for {@link GetUserServiceImpl#getUserBy(Username)}
     */
    @Test
    public void getUserByUsername() throws Exception {
        // given
        Username username = new Username("username");
        SecuredPassword password = new SecuredPassword("$2a$10$pm9iVvHtOICV.Qc/MGBr9exXG4zIgSZCQ2wMQuUysqisWt4hS1L2G");

        User user = new User(1L, username, new Email("up@a.com"), password);

        // when
        when(userRepositoryMock.findByUsername(username))
            .thenReturn(Optional.of(user));

        User result = service.getUserBy(username);

        // then
        assertSame(result, user);
    }

    /**
     * Test for {@link GetUserServiceImpl#getUserBy(Email)}
     */
    @Test
    public void getUserByEmail() throws Exception {
        // given
        Email email = new Email("up@a.com");
        SecuredPassword password = new SecuredPassword("$2a$10$pm9iVvHtOICV.Qc/MGBr9exXG4zIgSZCQ2wMQuUysqisWt4hS1L2G");

        User user = new User(1L, new Username("username"), email, password);

        // when
        when(userRepositoryMock.findByEmail(email))
            .thenReturn(Optional.of(user));

        User result = service.getUserBy(email);

        // then
        assertSame(result, user);
    }

    /**
     * Test for {@link GetUserServiceImpl#getUserBy(Username)}
     */
    @Test
    public void getNonExistedUserByUsername() throws Exception {
        // given
        Username username = new Username("username");

        // when / then
        when(userRepositoryMock.findByUsername(username))
            .thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> service.getUserBy(username));
    }

    /**
     * Test for {@link GetUserServiceImpl#getUserBy(Email)}
     */
    @Test
    public void getNonExistedUserByEmail() throws Exception {
        // given
        Email email = new Email("up@a.com");

        // when / then
        when(userRepositoryMock.findByEmail(email))
            .thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> service.getUserBy(email));
    }
}
