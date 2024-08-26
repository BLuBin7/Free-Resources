package com.blubin.freeresources.service;

import com.blubin.freeresources.controller.request.AuthenticationRequest;
import com.blubin.freeresources.controller.request.RegisterRequest;
import com.blubin.freeresources.dto.model.AuthenticationDto;
import com.blubin.freeresources.dto.model.UserDto;
import com.blubin.freeresources.model.User;
import com.blubin.freeresources.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
//@RequiredArgsConstructor
public interface AuthenticationService {
//    private final UserRepository userRepository;
//    private final AuthenticationManager authenticationManager;
    public UserDto register(RegisterRequest registerRequest) throws Exception;

//
//    public AuthenticationDto authenticate(AuthenticationRequest request) {
//        Optional<User> user = userRepository.findByEmail(request.getEmail());
//        if (user.isPresent()) {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            request.getEmail(),
//                            request.getPassword()
//                    )
//            );
//            String jwtToken = jwtService.generateToken(user.get());
//            boolean firstLogin = user.get().getFirstLogin();
//            if (firstLogin) {
//                user.get().setFirstLogin(false);
//                userRepository.save(user.get());
//            }
//            saveUserToken(user.get(), jwtToken);
//            return new AuthenticationDto()
//                    .setToken(jwtToken)
//                    .setUser(UserMapper.toUserDto(user.get()))
//                    .setFirstLogin(firstLogin);
//        }
//        throw exception(EntityType.USER, ExceptionType.ENTITY_NOT_FOUND, request.getEmail());
//    }
}
