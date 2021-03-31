package com.nitesh.springLearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
        UserDetails user1 = userBuilder
                .username("nikk1212")
                .password("nikk")
                .roles("USER")
                .build();
        UserDetails user2 = userBuilder
                .username("jain12")
                .password("jain")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
}
