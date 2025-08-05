package com.dairy.dairy_back.service;

import com.dairy.dairy_back.dto.UserDTO;
import com.dairy.dairy_back.model.Person;
import com.dairy.dairy_back.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;


    public String login(UserDTO dto) throws UsernameNotFoundException {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getPassword()));
        UserDetails user = userDetailsService.loadUserByUsername(dto.getEmail());
        String token = jwtService.generateToken(user.getUsername());
        return token;
    }

    public void create(UserDTO dto) {
        var user = new Person();
        user.setEmail(dto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        userRepository.save(user);
    }
}
