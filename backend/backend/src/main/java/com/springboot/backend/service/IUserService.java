package com.springboot.backend.service;

import com.springboot.backend.dto.request.UserCreationRequest;
import com.springboot.backend.dto.request.UserUpdateRequest;
import com.springboot.backend.dto.response.UserResponse;

import java.util.List;

public interface IUserService {
    public List<UserResponse> getAllUsers();

    public UserResponse createUser(UserCreationRequest request);

    public UserResponse getUserById(int userId);

    public UserResponse updateUser(int userId, UserUpdateRequest request);

    public void deleteUser(int userId);
}
