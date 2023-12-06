package com.Information_Project.infoproject.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf->
                        csrf
                                .disable())
                .authorizeHttpRequests((request)-> {

                            request
                                    .requestMatchers("/userAdd/**").permitAll();
                            request
                                    .requestMatchers("/userMas/**").permitAll();
                            request
                                    .anyRequest().authenticated();
                        }
                );
        return http.build();
    }

}
