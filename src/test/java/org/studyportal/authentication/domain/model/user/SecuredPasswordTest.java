package org.studyportal.authentication.domain.model.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SecuredPasswordTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-22
 */
public class SecuredPasswordTest {
    /**
     * Test for {@link SecuredPassword#SecuredPassword(String)}
     */
    @Test
    public void SecuredPassword() throws Exception {
        // given
        String passwordStr = "$2a$10$pm9iVvHtOICV.Qc/MGBr9exXG4zIgSZCQ2wMQuUysqisWt4hS1L2G";

        // when
        SecuredPassword password = new SecuredPassword(passwordStr);

        // then
        assertEquals(passwordStr, password.password());
    }

    /**
     * Test for {@link SecuredPassword#SecuredPassword(String)}
     */
    @Test
    public void SecuredPasswordWithNullableSecuredPassword() throws Exception {
        // when / then
        assertThrows(IllegalArgumentException.class, () -> new SecuredPassword(null));
    }

    /**
     * Test for {@link SecuredPassword#SecuredPassword(String)}
     */
    @Test
    public void SecuredPasswordWithTooLessSecuredPassword() throws Exception {
        // given
        String passwordStr = "$2a$10$pm9iVvHtOICV.Qc/MGBr9exXG4zIgSZCQ2wMQuUysqisWt4hS1L2";

        // when / then
        assertThrows(IllegalArgumentException.class, () -> new SecuredPassword(passwordStr));
    }

    /**
     * Test for {@link SecuredPassword#SecuredPassword(String)}
     */
    @Test
    public void SecuredPasswordWithToLargeSecuredPassword() throws Exception {
        // given
        String passwordStr = "$2a$10$pm9iVvHtOICV.Qc/MGBr9exXG4zIgSZCQ2wMQuUysqisWt4hS1L222";

        // when / then
        assertThrows(IllegalArgumentException.class, () -> new SecuredPassword(passwordStr));
    }
}
