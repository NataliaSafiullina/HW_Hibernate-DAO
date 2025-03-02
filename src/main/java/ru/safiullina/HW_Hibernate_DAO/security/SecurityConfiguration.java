package ru.safiullina.HW_Hibernate_DAO.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
// prePostEnabled = true не указан, так как true задан по умолчанию
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    /**
     * Настраивает хранилище пользователей в памяти.
     *
     * @return InMemoryUserDetailsManager, который хранит информацию о пользователе в самом приложении
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails reader = User.withUsername("reader")
                .password("{noop}read")
                .roles("READ")
                .build();

        UserDetails writer = User.withUsername("writer")
                .password("{noop}write")
                .roles("WRITE")
                .build();

        UserDetails leto = User.withUsername("Leto")
                .password("{noop}leto")
                .roles("DELETE")
                .build();

        return new InMemoryUserDetailsManager(reader, writer, leto);
    }

}
