package com.study.springsecurity.config;

import com.study.springsecurity.user.SecurityUser;
import com.study.springsecurity.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserDetailServiceConfig {

    @Bean
    public UserDetailsService userDetailService() {
        User user = new User("마잡개", "1357", "test@test.com");
        SecurityUser securityUser = new SecurityUser(user);
        return new InMemoryUserDetailsService(List.of(securityUser));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
