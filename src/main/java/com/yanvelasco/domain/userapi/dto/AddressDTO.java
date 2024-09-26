package com.yanvelasco.domain.userapi.dto;

import lombok.Builder;

@Builder
public record AddressDTO(
    String street,
    Long number,
    String complement,
    String city,
    String state,
    String zip_code
) {
}