package com.mockCommerce.mockCommerce.services.managers;

import com.mockCommerce.mockCommerce.util.mappers.user.UserMapperService;
import com.mockCommerce.mockCommerce.repository.UserRepository;
import com.mockCommerce.mockCommerce.entites.User;
import com.mockCommerce.mockCommerce.services.UserServices;
import com.mockCommerce.mockCommerce.dto.requests.user.UpdateUserRequest;
import com.mockCommerce.mockCommerce.dto.responses.user.GetByUsernameResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManager implements UserServices {
    private UserRepository userRepository;
    private UserMapperService userMapperService;

    @Override
    public GetByUsernameResponse getUsername(String username) {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
        return this.userMapperService.forResponse().map(user, GetByUsernameResponse.class);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user = this.userMapperService.forRequest().map(updateUserRequest, User.class);

        this.userRepository.save(user);
    }

    @Override
    public void delete(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
        if(user.isActive()){
            user.setActive(false);
        }
        this.userRepository.save(user);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
            }
        };
    }
}
