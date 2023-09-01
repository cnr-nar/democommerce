package com.mockCommerce.mockCommerce.services.managers;

import com.mockCommerce.mockCommerce.dto.requests.user.SignInRequest;
import com.mockCommerce.mockCommerce.dto.requests.user.SignUpRequest;
import com.mockCommerce.mockCommerce.dto.responses.JwtAuthResponse;
import com.mockCommerce.mockCommerce.entites.Role;
import com.mockCommerce.mockCommerce.entites.User;
import com.mockCommerce.mockCommerce.repository.UserRepository;
import com.mockCommerce.mockCommerce.services.AuthenticationService;
import com.mockCommerce.mockCommerce.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceManager implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public JwtAuthResponse signup(SignUpRequest request) {
        var user = User.builder().username(request.getUsername()).userFirstname(request.getUserFirstname())
                .userLastname(request.getUserLastname())
                .userEmail(request.getUserEmail()).
                password(passwordEncoder.encode(request.getPassword()))
                .role(Role.User).isActive(request.isActive()).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);

        return JwtAuthResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(()-> new IllegalArgumentException("Invalid username or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(jwt).build();
    }
}
