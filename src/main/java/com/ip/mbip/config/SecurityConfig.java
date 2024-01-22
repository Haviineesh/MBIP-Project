package com.ip.mbip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ip.mbip.service.UserService;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserService UserService(PasswordEncoder passwordEncoder) {
        return new UserService(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(UserService(passwordEncoder()))
                .passwordEncoder(passwordEncoder());
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/resources/**", "/static/**", "/webjars/**")
                        .permitAll()
                        .requestMatchers("/login", "/createaccount", "/forgotpassword", "/resetpassword")
                        .permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/dashboard", true))
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutUrl("/logout").permitAll())

                .csrf(AbstractHttpConfigurer::disable)
                .logout(logout -> logout.addLogoutHandler((request, response, authentication) -> {
                    SecurityContextHolder.clearContext();
                }))
                .build();
    }
}
