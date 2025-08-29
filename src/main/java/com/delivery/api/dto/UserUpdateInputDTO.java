package com.delivery.api.dto;

import com.delivery.domain.enums.UserEnum;
import lombok.*;
import java.util.UUID;

@Builder
public record UserUpdateInputDTO(UUID id, String fullname, String email, String password, String phone, UserEnum level) {
}
