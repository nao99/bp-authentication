package org.studyportal.authentication.domain.model.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * EmailTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-21
 */
public class EmailTest {
    /**
     * Test for {@link Email#Email(String)}
     */
    @Test
    public void Email() throws Exception {
        // given
        String emailStr = "nao99.dev@gmail.com";

        // when
        Email email = new Email(emailStr);

        // then
        assertEquals(emailStr, email.email());
    }

    /**
     * Test for {@link Email#Email(String)}
     */
    @Test
    public void EmailWithNullableEmail() throws Exception {
        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
    }

    /**
     * Test for {@link Email#Email(String)}
     */
    @Test
    public void EmailWithTooLessEmail() throws Exception {
        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Email("a@be.c"));
    }

    /**
     * Test for {@link Email#Email(String)}
     */
    @Test
    public void EmailWithToLargeEmail() throws Exception {
        // given
        String emailStr = "a".repeat(48);

        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Email(emailStr));
    }

    /**
     * Test for {@link Email#Email(String)}
     */
    @Test
    public void EmailWithInvalidEmail() throws Exception {
        // given
        String emailStr = "invalid_email";

        // when / then
        assertThrows(IllegalArgumentException.class, () -> new Email(emailStr));
    }
}
