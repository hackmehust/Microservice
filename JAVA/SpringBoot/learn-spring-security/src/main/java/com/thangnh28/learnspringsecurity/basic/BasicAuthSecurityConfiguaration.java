package com.thangnh28.learnspringsecurity.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class BasicAuthSecurityConfiguaration {
    // Class: SpringBootWebSecurityConfiguration
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                auth -> {
                    auth.anyRequest().authenticated();
                });
        http.sessionManagement(
                session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS)
                ) ; // SessionCreationPolicy xem các thuộc tính bên trong

//        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        http.csrf(AbstractHttpConfigurer::disable); // Disable CSRF protection
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        var user = User.withUsername("in28minutes")
                .password("{noop}dummy")
                .roles("USER")
                .build();

        var admin = User.withUsername("admin")
                .password("{noop}dummy")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
