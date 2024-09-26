package com.yanvelasco.domain.userapi.controller;

import com.yanvelasco.domain.userapi.dto.UserDTO;
import com.yanvelasco.domain.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> save(UserDTO userDTO) {
        return userService.save(userDTO);
    }

}