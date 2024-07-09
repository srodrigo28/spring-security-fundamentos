package com.sebsolucoes.securityapp.config;

import org.springframework.http.HttpMethod;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf( csrf -> csrf.disable())
            .authorizeHttpRequests( (requests) -> requests
            .requestMatchers(HttpMethod.POST, "/user/**").permitAll()
            .anyRequest()
            .authenticated());
        return http.build();
    }
}
