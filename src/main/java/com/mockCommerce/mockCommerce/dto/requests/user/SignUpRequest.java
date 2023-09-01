package com.mockCommerce.mockCommerce.dto.requests.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    private String username;
    private String userFirstname;
    private String userLastname;
    private String userEmail;
    private String password;
    @JsonIgnore
    private String userRole = "USER";
    @JsonIgnore
    boolean isActive = true;
}
