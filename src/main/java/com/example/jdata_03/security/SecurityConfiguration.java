package com.example.jdata_03.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                (authorize) -> authorize
                        .requestMatchers("/persons/all").permitAll() // Доступ ВСЕМ без логина и авторизации
                        .requestMatchers("/persons/by-city").hasRole("read")
                        .requestMatchers("/persons").hasRole("write")
                        .anyRequest().authenticated()
                )
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList<>();
        users.add(User.builder()
                .username("maximilian")
                .password(encoder().encode("123456"))
                .roles("read")
                .build());
        users.add(User.builder()
                .username("potap")
                .password(encoder().encode("123456"))
                .roles("write")
                .build());
        users.add(User.builder()
                .username("kassandra")
                .password(encoder().encode("123456"))
                .roles("read", "write")
                .build());
        return new InMemoryUserDetailsManager(users);
    }
}
