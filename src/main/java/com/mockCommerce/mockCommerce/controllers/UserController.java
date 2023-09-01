package com.mockCommerce.mockCommerce.controllers;

import com.mockCommerce.mockCommerce.entites.User;
import com.mockCommerce.mockCommerce.services.UserServices;
import com.mockCommerce.mockCommerce.dto.requests.user.UpdateUserRequest;
import com.mockCommerce.mockCommerce.dto.responses.user.GetByUsernameResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserServices userServices;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/{username}")
    public GetByUsernameResponse getByUsernameResponse(@PathVariable String username){
        return userServices.getUsername(username);

    }


    @PutMapping("/{username}")
    public void update(@RequestBody UpdateUserRequest updateUserRequest,@PathVariable String username) {
        GetByUsernameResponse user = this.userServices.getUsername(username);
        updateUserRequest.setUserId(user.getUserId());
        updateUserRequest.setRole(user.getRole());

        if(updateUserRequest.getUsername() == null || updateUserRequest.getUsername().isEmpty()){
            updateUserRequest.setUsername(user.getUsername());
        }

        if(updateUserRequest.getUserEmail() == null  || updateUserRequest.getUserEmail().isEmpty() ){
            updateUserRequest.setUserEmail(user.getUserEmail());
        }

        if(updateUserRequest.getUserFirstname() == null || updateUserRequest.getUserFirstname().isEmpty()){
            updateUserRequest.setUserFirstname(user.getUserFirstname());
        }

        if(updateUserRequest.getUserLastname() == null || updateUserRequest.getUserLastname().isEmpty()){
            updateUserRequest.setUserLastname(user.getUserLastname());
        }

        if (updateUserRequest.getPassword() == null || updateUserRequest.getPassword().isEmpty()) {
            updateUserRequest.setPassword(user.getPassword());
        } else {
            updateUserRequest.setPassword(passwordEncoder.encode(updateUserRequest.getPassword()));
        }

        this.userServices.update(updateUserRequest);
    }

    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username){
        this.userServices.delete(username);
    }
}
