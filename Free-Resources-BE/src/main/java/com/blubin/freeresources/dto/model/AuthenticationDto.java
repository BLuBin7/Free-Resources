package com.blubin.freeresources.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDto {
    private String token;

    private UserDto user;

    private Boolean firstLogin;
}