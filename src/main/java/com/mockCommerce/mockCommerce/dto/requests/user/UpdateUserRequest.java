package com.mockCommerce.mockCommerce.dto.requests.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    @JsonIgnore
    private int    userId;
    private String username;
    private String userFirstname;
    private String userLastname;
    private String userEmail;
    private String password;
    @JsonIgnore
    private String role = "USER";
}
