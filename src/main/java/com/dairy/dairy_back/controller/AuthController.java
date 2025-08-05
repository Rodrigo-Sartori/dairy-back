package com.dairy.dairy_back.controller;

import com.dairy.dairy_back.dto.UserDTO;
import com.dairy.dairy_back.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserAuthService userAuthService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        String token = userAuthService.login(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        userAuthService.create(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }
}
