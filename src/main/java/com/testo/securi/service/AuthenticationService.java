package com.testo.securi.service;

import com.testo.securi.dao.request.SignInRequest;
import com.testo.securi.dao.request.SignUpRequest;
import com.testo.securi.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SignInRequest request);
}
