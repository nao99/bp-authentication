package bp.authentication.service;

import bp.authentication.exception.UserNotFoundException;
import bp.authentication.model.User;
import bp.authentication.model.UserPassword;
import bp.authentication.model.UserUsername;
import bp.authentication.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * UserServiceImplTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-06
 */
@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {
    /**
     * User repository mock
     */
    @MockBean
    private UserRepository repositoryMock;

    /**
     * User service
     */
    private UserServiceImpl service;

    /**
     * Sets up
     */
    @BeforeEach
    public void setUp() throws Exception {
        service = new UserServiceImpl(repositoryMock);
    }

    /**
     * Test for {@link UserServiceImpl#getUser(Long)}
     */
    @Test
    public void getUser() throws Exception {
        // given
        Long userId = 1L;
        User user = new User(userId, new UserUsername("username"), new UserPassword("password"));

        // when
        when(repositoryMock.findById(userId))
            .thenReturn(Optional.of(user));

        User result = service.getUser(userId);

        // then
        assertSame(result, user);
    }

    /**
     * Test for {@link UserServiceImpl#getUser(Long)}
     */
    @Test
    public void getNonExistedUser() throws Exception {
        // given
        Long userId = 1L;

        // when / then
        when(repositoryMock.findById(userId))
            .thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> service.getUser(userId));
    }
}
