package com.blubin.freeresources.dto.mapper;

import com.blubin.freeresources.dto.model.UserDto;
import com.blubin.freeresources.model.User;

public class UserMapper {
    public static UserDto toUserMapper(User user){
        return new UserDto()
                .setId(user.getId())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setMobileNumber(user.getMobileNumber())
                .setAvatar(user.getAvatar())
                .setRole(user.getRole());
    }
}
