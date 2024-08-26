package com.blubin.freeresources.service.impl;

import com.blubin.freeresources.controller.request.RegisterRequest;
import com.blubin.freeresources.dto.mapper.UserMapper;
import com.blubin.freeresources.dto.model.UserDto;
import com.blubin.freeresources.model.Role;
import com.blubin.freeresources.model.Token;
import com.blubin.freeresources.model.TokenType;
import com.blubin.freeresources.model.User;
import com.blubin.freeresources.repository.TokenRepository;
import com.blubin.freeresources.repository.UserRepository;
import com.blubin.freeresources.service.AuthenticationService;
import com.blubin.freeresources.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepositor;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    @Override
    public UserDto register(RegisterRequest registerRequest) throws Exception {
        Optional<User> users = userRepositor.findByEmail(registerRequest.getEmail());
        if(users.isEmpty()) {
            User newUser = new User()
                    .setEmail(registerRequest.getEmail())
                    .setPassword(registerRequest.getPassword())
                    .setFirstName(registerRequest.getFirstName())
                    .setLastName(registerRequest.getLastName())
                    .setMobileNumber(registerRequest.getMobileNumber())
                    .setAvatar("avatar.jpg")
                    .setRole(Role.USER);
            User saveUser = userRepositor.save(newUser);
            String jwtToken = jwtService.generateToken(newUser);
            System.out.println(jwtToken);
            saveUserToken(newUser, jwtToken);
            return UserMapper.toUserMapper(saveUser);
        }
        throw new Exception();
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = new Token()
                .setUser(user)
                .setToken(jwtToken)
                .setTokenType(TokenType.BEARER)
                .setRevoked(false)
                .setExpired(false);
        tokenRepository.save(token);
    }


}
