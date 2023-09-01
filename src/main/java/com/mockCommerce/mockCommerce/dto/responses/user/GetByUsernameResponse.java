package com.mockCommerce.mockCommerce.dto.responses.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByUsernameResponse {
    @JsonIgnore
    private int    userId;
    private String username;
    private String userFirstname;
    private String userLastname;
    private String userEmail;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String role = "USER";
    @JsonIgnore
    boolean isActive;
}
