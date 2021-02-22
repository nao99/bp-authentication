package bp.authentication.domain.model.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PasswordTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-22
 */
public class PasswordTest {
    /**
     * Test for {@link Password#Password(String)}
     */
    @Test
    public void Password() throws Exception {
        // given
        String passwordStr = "sadNE33!";

        // when
        Password password = new Password(passwordStr);

        // then
        assertEquals(passwordStr, password.password());
    }

    /**
     * Test for {@link Password#Password(String)}
     */
    @Test
    public void PasswordWithNullablePassword() throws Exception {
        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Password(null));
    }

    /**
     * Test for {@link Password#Password(String)}
     */
    @Test
    public void PasswordWithTooLessPassword() throws Exception {
        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Password("cccccc"));
    }

    /**
     * Test for {@link Password#Password(String)}
     */
    @Test
    public void PasswordWithToLargePassword() throws Exception {
        // given
        String passwordStr = "a".repeat(33);

        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Password(passwordStr));
    }

    /**
     * Test for {@link Password#Password(String)}
     */
    @Test
    public void PasswordWithInvalidPassword() throws Exception {
        // given
        String passwordStr = "&sadf;l";

        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Password(passwordStr));
    }
}
