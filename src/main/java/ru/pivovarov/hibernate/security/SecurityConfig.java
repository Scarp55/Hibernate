package ru.pivovarov.hibernate.security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
class WebSecurityConfig {

   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().formLogin()
                .and()
                .authorizeHttpRequests().requestMatchers("/persons/by-city").permitAll()
                .and()
                .authorizeHttpRequests().anyRequest().authenticated();
        return http.build();
    }
}
