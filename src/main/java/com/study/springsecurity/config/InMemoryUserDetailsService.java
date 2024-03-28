package com.study.springsecurity.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.List;

public class InMemoryUserDetailsService implements UserDetailsService {

    private final List<UserDetails> users;

    public InMemoryUserDetailsService(List<UserDetails> users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return users.stream()
                .filter(
                        u -> u.getUsername().equals(username)
                )
                .findAny()
                .orElseThrow(
                        () -> new UsernameNotFoundException("유저를 찾을 수 없습니다.")
                );
    }
}
