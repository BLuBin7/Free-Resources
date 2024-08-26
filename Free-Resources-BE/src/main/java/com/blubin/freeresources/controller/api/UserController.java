package com.blubin.freeresources.controller.api;

import com.blubin.freeresources.dto.model.UserDto;
import com.blubin.freeresources.dto.response.Response;
import com.blubin.freeresources.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<Response> getUser(@PathVariable("id") Integer id){
        log.info("UserController::getUser by id {}", id);
        UserDto userDto = userService.getUser(id);

        Response<Object> response = Response.ok().setPayload(userDto);
        log.info("UserController::getUser by id {} respomse {}",id,response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
