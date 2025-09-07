package com.delivery.api.dto;

import com.delivery.domain.enums.UserEnum;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UserOutputDTO(UUID id, String fullName, String email, String phone, UserEnum level) {
}
