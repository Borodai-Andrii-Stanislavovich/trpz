package org.example.userservice.controller;

import org.example.userservice.dto.AuthRequest;
import org.example.userservice.dto.AuthResponse;
import org.example.userservice.entity.User;
import org.example.userservice.service.JwtService;
import org.example.userservice.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder encoder;

    public AuthController(UserService userService, JwtService jwtService, BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        User user = userService.findByUsername(request.username);

        if (!encoder.matches(request.password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return new AuthResponse(jwtService.generateToken(user.getUsername()));
    }
}
