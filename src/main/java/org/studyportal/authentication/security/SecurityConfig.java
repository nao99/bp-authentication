package org.studyportal.authentication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SecurityConfig class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-25
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * User login success handler
     */
    private final UserLoginSuccessHandler loginSuccessHandler;

    /**
     * User logout success handler
     */
    private final UserLogoutSuccessHandler logoutSuccessHandler;

    /**
     * SecurityConfig constructor
     *
     * @param loginSuccessHandler  a user login success handler
     * @param logoutSuccessHandler a user logout success handler
     */
    @Autowired
    public SecurityConfig(
        final UserLoginSuccessHandler loginSuccessHandler,
        final UserLogoutSuccessHandler logoutSuccessHandler
    ) {
        this.loginSuccessHandler = loginSuccessHandler;
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    /**
     * Gets a password encoder as {@link BCryptPasswordEncoder}
     *
     * @return a BCrypt password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure(final HttpSecurity security) throws Exception {
        security
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeRequests()
                .antMatchers("/api/v1.0/auth/**").permitAll()
            .anyRequest().authenticated()
                .and().formLogin((formLogin) -> {
                    formLogin
                        .loginProcessingUrl("/api/v1.0/auth/login")
                        .successHandler(loginSuccessHandler);
                })
                .logout((logout) -> {
                    logout
                        .logoutUrl("/api/v1.0/auth/logout")
                        .logoutSuccessHandler(logoutSuccessHandler);
                });
    }
}
