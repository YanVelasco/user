package com.yanvelasco.domain.userapi.service;

import com.yanvelasco.domain.userapi.dto.UserDTO;
import com.yanvelasco.domain.userapi.entities.UserEntity;
import com.yanvelasco.domain.userapi.exceptions.ConflictException;
import com.yanvelasco.domain.userapi.mapper.UserMapper;
import com.yanvelasco.domain.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ResponseEntity<UserDTO> save(UserDTO userDTO) {
        existsByEmail(userDTO.email());
        System.out.println("UserDTO: " + userDTO.password());
        UserEntity userEntity = userMapper.toEntity(userDTO);
        userRepository.save(userEntity);
        return ResponseEntity
                .status(HttpStatusCode
                        .valueOf(userEntity.getId() != null ? 201 : 400))
                .body(userMapper.toDTO(userEntity));
    }

    public void existsByEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new ConflictException("Email already exists");
        }
    }

    public boolean verifyEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}