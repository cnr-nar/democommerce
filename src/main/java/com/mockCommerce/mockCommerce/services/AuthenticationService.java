package com.mockCommerce.mockCommerce.services;

import com.mockCommerce.mockCommerce.dto.requests.user.SignInRequest;
import com.mockCommerce.mockCommerce.dto.requests.user.SignUpRequest;
import com.mockCommerce.mockCommerce.dto.responses.JwtAuthResponse;

public interface AuthenticationService {
    JwtAuthResponse signup(SignUpRequest request);
    JwtAuthResponse signin(SignInRequest request);
}
