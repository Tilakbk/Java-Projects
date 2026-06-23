package com.hcms.hostelcomplaintmanagementsystem.config;


import com.hcms.hostelcomplaintmanagementsystem.jwt.JwtAccessDeniedHandler;
import com.hcms.hostelcomplaintmanagementsystem.jwt.JwtAuthenticationEntryPoint;
import com.hcms.hostelcomplaintmanagementsystem.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler accessDeniedHandler;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
    {
       return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors-> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(auth-> auth

//                       For Public access
                                .requestMatchers("/api/auth/**").permitAll()

                                .requestMatchers("/swagger-ui/**","/v3/api-docs/**").permitAll()




//                        For System Admin
                                .requestMatchers(HttpMethod.POST,"/api/hostel").hasRole("SYSTEM_ADMIN")
                                .requestMatchers(HttpMethod.GET,"/api/hostel").hasRole("SYSTEM_ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/hostel/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/api/hostel/**").hasRole("SYSTEM_ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/hostel/**").hasRole("SYSTEM_ADMIN")


//                      For WARDEN

                                .requestMatchers(HttpMethod.POST, "/api/staff").hasAnyRole("WARDEN","SYSTEM_ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/staff/**").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.PATCH,"/api/staff/**").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.DELETE, "/api/staff/**").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.GET, "/api/staff/**").hasRole("WARDEN")


                                .requestMatchers(HttpMethod.POST, "/api/room").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.GET, "/api/room/**").authenticated()
                                .requestMatchers(HttpMethod.POST, "/api/category").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.PUT, "/api/category/**").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.DELETE, "/api/category/**").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.GET, "/api/category/**").authenticated()

                                .requestMatchers(HttpMethod.GET, "/api/students").hasAnyRole("WARDEN", "SYSTEM_ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/students/**").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.POST,"/api/students").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.GET, "/api/students/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/api/students/**").authenticated()
                                .requestMatchers(HttpMethod.PATCH, "/api/students/**").authenticated()


//                        For managing complaints

                                .requestMatchers(HttpMethod.POST, "/api/complaint").hasRole("STUDENT")
                                .requestMatchers(HttpMethod.PUT, "/api/complaint/*/staff/*").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.PUT, "/api/complaint/*/resolve").hasRole("STAFF")
                                .requestMatchers(HttpMethod.DELETE, "/api/complaint/**").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.GET, "/api/complaint/**").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/api/complaint/**").authenticated()

//                        For managing Resolution log

                                .requestMatchers(HttpMethod.POST, "/api/resolution-log").hasRole("STAFF")
                                .requestMatchers(HttpMethod.PUT, "/api/resolution-log/**").hasRole("STAFF")
                                .requestMatchers(HttpMethod.DELETE, "/api/resolution-log/**").hasRole("WARDEN")
                                .requestMatchers(HttpMethod.GET, "/api/resolution-log").hasAnyRole("WARDEN", "SYSTEM_ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/resolution-log/**").authenticated()

                                .anyRequest().authenticated()
                )

                .exceptionHandling(ex-> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler))

                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)

                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration corsConfiguration= new CorsConfiguration();

        corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000","http://localhost:3456"));
        corsConfiguration.setAllowedMethods(List.of("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
        corsConfiguration.setAllowedHeaders(List.of("Authorization",
                "Content-Type",
                "Accept",
                "X-Requested-With"));
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);

        return source;



    }


}
