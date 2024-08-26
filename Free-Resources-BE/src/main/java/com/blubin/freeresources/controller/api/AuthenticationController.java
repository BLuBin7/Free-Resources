package com.blubin.freeresources.controller.api;

import com.blubin.freeresources.controller.request.AuthenticationRequest;
import com.blubin.freeresources.controller.request.RegisterRequest;
import com.blubin.freeresources.dto.model.AuthenticationDto;
import com.blubin.freeresources.dto.response.Response;
import com.blubin.freeresources.model.User;
import com.blubin.freeresources.repository.UserRepository;
import com.blubin.freeresources.service.AuthenticationService;
import com.blubin.freeresources.util.ValueMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody @Valid RegisterRequest request) throws Exception {
        log.info("AuthenticationController::register request body {}", ValueMapper.jsonAsString(request));
        Response<Object> response = Response.ok().setPayload(authenticationService.register(request));
        log.info("AuthenticationController::register response {}", ValueMapper.jsonAsString(response));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
