package com.yanvelasco.domain.userapi.mapper;

import com.yanvelasco.domain.userapi.dto.AddressDTO;
import com.yanvelasco.domain.userapi.dto.PhoneDTO;
import com.yanvelasco.domain.userapi.dto.UserDTO;
import com.yanvelasco.domain.userapi.entities.AddressEntity;
import com.yanvelasco.domain.userapi.entities.PhoneEntity;
import com.yanvelasco.domain.userapi.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserEntity toEntity(UserDTO userDTO) {
        if (userDTO.password() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        return UserEntity.builder()
                .name(userDTO.name())
                .email(userDTO.email())
                .password(passwordEncoder.encode(userDTO.password()))
                .addresses(userDTO.addresses().stream().map(this::toEntity).collect(Collectors.toList()))
                .phones(userDTO.phones().stream().map(this::toEntity).collect(Collectors.toList()))
                .build();
    }

    public UserDTO toDTO(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getAddresses().stream().map(this::toDTO).collect(Collectors.toList()),
                userEntity.getPhones().stream().map(this::toDTO).collect(Collectors.toList())
        );
    }

    public AddressEntity toEntity(AddressDTO addressDTO) {
        return AddressEntity.builder()
                .street(addressDTO.street())
                .number(addressDTO.number())
                .complement(addressDTO.complement())
                .city(addressDTO.city())
                .state(addressDTO.state())
                .zip_code(addressDTO.zip_code())
                .build();
    }

    public AddressDTO toDTO(AddressEntity addressEntity) {
        return new AddressDTO(
                addressEntity.getStreet(),
                addressEntity.getNumber(),
                addressEntity.getComplement(),
                addressEntity.getCity(),
                addressEntity.getState(),
                addressEntity.getZip_code()
        );
    }

    public PhoneEntity toEntity(PhoneDTO phoneDTO) {
        return PhoneEntity.builder()
                .numbers(phoneDTO.numbers())
                .ddd(phoneDTO.ddd())
                .build();
    }

    public PhoneDTO toDTO(PhoneEntity phoneEntity) {
        return new PhoneDTO(
                phoneEntity.getNumbers(),
                phoneEntity.getDdd()
        );
    }

}