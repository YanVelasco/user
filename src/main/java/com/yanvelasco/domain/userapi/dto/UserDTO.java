package com.yanvelasco.domain.userapi.dto;

import lombok.Builder;

import java.util.List;
@Builder
public record UserDTO(
    String name,
    String email,
    String password,
    List<AddressDTO> addresses,
    List<PhoneDTO> phones
) {
}