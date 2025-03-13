package com.springboot.backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 4, message = "USERNAME_INVALID")
    @NotNull(message = "Username must not be null")
    String username;
    @Email(message = "INVALID_EMAIL")
    @NotNull(message = "Email must not be null")
    String email;
    @Size(min = 8, message = "INVALID_PASSWORD")
    @NotNull(message = "Password must not be null")
    String password;
}
