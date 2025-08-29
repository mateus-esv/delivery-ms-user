package com.delivery.api.dto;

import lombok.*;
import java.util.UUID;

@Builder
public record UserUpdateInputDTO(UUID id, String fullname, String email, String password, String phone, String level) {
}
