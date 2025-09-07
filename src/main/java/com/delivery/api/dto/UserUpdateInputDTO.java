package com.delivery.api.dto;

import com.delivery.domain.enums.UserEnum;
import lombok.*;
import java.util.UUID;

@Builder
public record UserUpdateInputDTO(UUID id, String fullName, String email, String phone, UserEnum level) {
}
