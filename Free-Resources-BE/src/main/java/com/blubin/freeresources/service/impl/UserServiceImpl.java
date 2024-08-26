package com.blubin.freeresources.service.impl;

import com.blubin.freeresources.dto.mapper.UserMapper;
import com.blubin.freeresources.dto.model.UserDto;
import com.blubin.freeresources.model.User;
import com.blubin.freeresources.repository.UserRepository;
import com.blubin.freeresources.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto getUser(Integer id) {
        log.info("UserService::getUsers execution started");
        UserDto userDto;

        log.debug("UserService::getUser request parameters id {}", id);
        User user  = userRepository.findById(id)
                .orElseThrow(() ->{
                    log.error("UserService::getUser execution failed with user not found {}",id);
                    return new RuntimeException("user is not found ");
                });
        userDto = UserMapper.toUserMapper(user);
        log.debug("UserService::getUser received response from database {}", userDto);

        log.info("UserService::getUser execution completed");
        return userDto;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
