package com.springboot.backend.service.impl;

import com.springboot.backend.dto.request.UserCreationRequest;
import com.springboot.backend.dto.request.UserUpdateRequest;
import com.springboot.backend.dto.response.UserResponse;
import com.springboot.backend.exception.AppException;
import com.springboot.backend.exception.ErrorCode;
import com.springboot.backend.mapper.UserMapper;
import com.springboot.backend.model.User;
import com.springboot.backend.repository.UserRepository;
import com.springboot.backend.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
    }

    public UserResponse createUser(UserCreationRequest request) {
        boolean exitsUser = userRepository.existsByUsername(request.getUsername());
        if (exitsUser) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public User userById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
    }

    @Override
    public UserResponse getUserById(int userId) {
        User user = userById(userId);
        assert user != null;
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse updateUser(int userId, UserUpdateRequest request) {
        User user = userById(userId);
        if (user != null) {
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            userRepository.save(user);
            return userMapper.toUserResponse(user);
        }
        return null;
    }

    @Override
    public void deleteUser(int userId) {
        User user = userById(userId);
        if (user != null) {
            userRepository.delete(user);
        }
    }
}
