package com.yanvelasco.domain.userapi.dto;

import lombok.Builder;

@Builder
public record PhoneDTO(
    String numbers,
    String ddd
) {
}