package com.mockCommerce.mockCommerce.controllers;

import com.mockCommerce.mockCommerce.dto.requests.user.SignInRequest;
import com.mockCommerce.mockCommerce.dto.requests.user.SignUpRequest;
import com.mockCommerce.mockCommerce.dto.responses.JwtAuthResponse;
import com.mockCommerce.mockCommerce.dto.responses.user.GetByUsernameResponse;
import com.mockCommerce.mockCommerce.services.AuthenticationService;
import com.mockCommerce.mockCommerce.services.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserServices userServices;


    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@Valid @RequestBody SignUpRequest request) {

            return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signin(@Valid @RequestBody SignInRequest request){
        GetByUsernameResponse response = this.userServices.getUsername(request.getUsername());
        request.setActive(response.isActive());
        if (request.isActive()){
            return ResponseEntity.ok(authenticationService.signin(request));
        }

        throw new UsernameNotFoundException("User Not Found");

    }

}
