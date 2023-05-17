package com.example.SpringSecurity.service.imple;

import com.example.SpringSecurity.entity.UserEntity;
import com.example.SpringSecurity.model.UserRequestModel;
import com.example.SpringSecurity.model.UserResponseModel;
import com.example.SpringSecurity.repository.UserRepository;
import com.example.SpringSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Object> register(UserRequestModel requestModel) {
        UserEntity userEntity = UserEntity.builder()
                .email(requestModel.getEmail())
                .username(requestModel.getUsername())
                .firstname(requestModel.getFirstname())
                .lastname(requestModel.getLastname())
                .password(requestModel.getPassword())
                .build();
        UserEntity savedUserEntity = userRepository.save(userEntity);

        UserResponseModel urm = UserResponseModel.builder()
                .email(requestModel.getEmail())
                .firstname(requestModel.getFirstname())
                .username(requestModel.getUsername())
                .build();
        return new ResponseEntity<>(urm, HttpStatus.CREATED);


    }
}
