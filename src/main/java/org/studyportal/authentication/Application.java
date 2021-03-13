package org.studyportal.authentication;

import org.studyportal.authentication.security.ClientCookieProperties;
import org.studyportal.authentication.storage.TokenStorageRedisProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Application class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-04
 */
@SpringBootApplication
@EnableConfigurationProperties(value = {
    TokenStorageRedisProperties.class,
    ClientCookieProperties.class,
})
public class Application {
    /**
     * The application entry point
     *
     * @param args application arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
