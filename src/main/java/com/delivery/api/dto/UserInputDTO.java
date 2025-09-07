package com.delivery.api.dto;

import com.delivery.domain.enums.UserEnum;
import lombok.*;

@Builder
public record UserInputDTO(String fullName, String email, String phone, UserEnum level) {
}
