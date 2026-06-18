package com.hcms.hostelcomplaintmanagementsystem.config;

import com.hcms.hostelcomplaintmanagementsystem.jwt.AccessDeniedHandler;
import com.hcms.hostelcomplaintmanagementsystem.jwt.JwtAuthenticationEntryPoint;
import com.hcms.hostelcomplaintmanagementsystem.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final AccessDeniedHandler accessDeniedHandler;
    private final AuthenticationProvider authenticationProvider;


}
