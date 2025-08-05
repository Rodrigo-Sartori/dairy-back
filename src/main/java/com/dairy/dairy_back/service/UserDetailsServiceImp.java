package com.dairy.dairy_back.service;

import com.dairy.dairy_back.model.Person;
import com.dairy.dairy_back.model.UserAuth;
import com.dairy.dairy_back.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User do not exist in database"));
        return UserAuth.builder()
                .username(person.getEmail())
                .password(person.getPassword())
                .build();
    }
}
