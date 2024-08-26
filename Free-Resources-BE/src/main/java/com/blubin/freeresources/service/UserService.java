package com.blubin.freeresources.service;

import com.blubin.freeresources.dto.model.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService {
    public UserDto getUser(Integer id);
    UserDetailsService userDetailsService();

}
