package com.springboot.backend.controller;

import com.springboot.backend.dto.request.UserCreationRequest;
import com.springboot.backend.dto.request.UserUpdateRequest;
import com.springboot.backend.dto.response.ApiResponse;
import com.springboot.backend.dto.response.UserResponse;
import com.springboot.backend.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUsers(){
        return ApiResponse.<List<UserResponse>>builder()
                .data(userService.getAllUsers())
                .build();
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserResponse> getUserById(@PathVariable("userId") int userId){
        return ApiResponse.<UserResponse>builder()
                .data(userService.getUserById(userId))
                .build();
    }

    @PostMapping
    public ApiResponse<UserResponse> creteUser(@RequestBody UserCreationRequest request){
        return ApiResponse.<UserResponse>builder()
                .data(userService.createUser(request))
                .build();
    }

    @PutMapping("/{userId}")
    public ApiResponse<UserResponse> updateUser(@PathVariable("userId") int userId, @RequestBody UserUpdateRequest request){
        return ApiResponse.<UserResponse>builder()
                .data(userService.updateUser(userId, request))
                .build();
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<Void> deleteUser(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
        return ApiResponse.<Void>builder()
                .build();
    }
}
