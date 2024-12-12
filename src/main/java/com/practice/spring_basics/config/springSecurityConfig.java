package com.practice.spring_basics.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class springSecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((req) -> req
                        .requestMatchers("/demo", "/demo/one") // Specify paths that do not require authentication
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin(withDefaults());

        return http.build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        UserDetails userOne = users
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        UserDetails usertwo = users
                .username("usertwo")
                .password("usertwo")
                .roles("ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(userOne, usertwo);
    }
}
