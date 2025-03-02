package ru.safiullina.HW_Hibernate_DAO.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    /**
     * Метод кодировщик паролей, который делегирует полномочия другому кодировщику паролей
     * на основе префиксного идентификатора, например {bcrypt}.
     *
     * @return the PasswordEncoder to use
     */
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * Настраивает хранилище пользователей в памяти.
     *
     * @return InMemoryUserDetailsManager, который хранит информацию о пользователе в самом приложении
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{noop}user")
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    /**
     * Конфигурируем безопасность на уровне endpoint
     *
     * @param http - объект, в котором сконфигурируем ограничения доступа.
     * @return какой способ аутентификации использовать и для какого endpoint
     * @throws Exception
     */
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/persons/by-city").permitAll()
                        .requestMatchers("/persons/by-age").authenticated()
                        .requestMatchers("/persons/by-names").hasRole("ADMIN"))
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

}
