package com.springboot.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    @JsonProperty("user_id")
    int userId;
    String username;
    String email;
    String password;
    String role;
    @JsonProperty("created_at")
    Date createdDate;
}
