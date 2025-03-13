package com.springboot.backend.mapper;

import com.springboot.backend.dto.request.UserCreationRequest;
import com.springboot.backend.dto.response.UserResponse;
import com.springboot.backend.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserMapper {
    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .createdDate(user.getCreatedDate())
                .build();
    }

    public User toUser(UserCreationRequest request){
        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .role("USER")
                .createdDate(new Date())
                .build();
    }
}
