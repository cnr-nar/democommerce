package com.mockCommerce.mockCommerce.services;

import com.mockCommerce.mockCommerce.dto.requests.user.UpdateUserRequest;
import com.mockCommerce.mockCommerce.dto.responses.user.GetByUsernameResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServices {
    GetByUsernameResponse getUsername(String username);

    void update(UpdateUserRequest updateUserRequest);

    void delete(String username);

    UserDetailsService userDetailsService();
}
