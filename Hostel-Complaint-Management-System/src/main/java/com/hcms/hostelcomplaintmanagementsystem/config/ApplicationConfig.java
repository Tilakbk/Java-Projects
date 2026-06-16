package com.hcms.hostelcomplaintmanagementsystem.config;

import com.hcms.hostelcomplaintmanagementsystem.user.CustomUserDetailService;
import com.hcms.hostelcomplaintmanagementsystem.user.UserPrinciple;
import com.hcms.hostelcomplaintmanagementsystem.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final CustomUserDetailService customUserDetailService;


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider(customUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
    {
       return authenticationConfiguration.getAuthenticationManager();
    }




}
