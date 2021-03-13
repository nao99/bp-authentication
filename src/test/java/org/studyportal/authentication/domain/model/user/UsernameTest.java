package org.studyportal.authentication.domain.model.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UsernameTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-22
 */
public class UsernameTest {
    /**
     * Test for {@link Username#Username(String)}
     */
    @Test
    public void Username() throws Exception {
        // given
        String usernameStr = "_nao99_";

        // when
        Username username = new Username(usernameStr);

        // then
        assertEquals(usernameStr, username.username());
    }

    /**
     * Test for {@link Username#Username(String)}
     */
    @Test
    public void UsernameWithNullableUsername() throws Exception {
        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Username(null));
    }

    /**
     * Test for {@link Username#Username(String)}
     */
    @Test
    public void UsernameWithTooLessUsername() throws Exception {
        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Username("c"));
    }

    /**
     * Test for {@link Username#Username(String)}
     */
    @Test
    public void UsernameWithToLargeUsername() throws Exception {
        // given
        String usernameStr = "a".repeat(33);

        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Username(usernameStr));
    }

    /**
     * Test for {@link Username#Username(String)}
     */
    @Test
    public void UsernameWithInvalidUsername() throws Exception {
        // given
        String usernameStr = "&sadf;l";

        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Username(usernameStr));
    }
}
