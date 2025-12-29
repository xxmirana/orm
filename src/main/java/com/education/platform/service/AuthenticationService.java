package com.education.platform.service;

import com.education.platform.config.TokenManager;
import com.education.platform.entity.PlatformUser;
import com.education.platform.repository.PlatformUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PlatformUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenManager tokenManager;
    private final AuthenticationManager authenticationManager;

    public String register(PlatformUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return tokenManager.createToken(user);
    }

    public String authenticate(PlatformUser user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );
        PlatformUser foundUser = userRepository.findByEmail(user.getEmail()).orElseThrow();
        return tokenManager.createToken(foundUser);
    }
}