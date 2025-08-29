package com.delivery.api.dto;

import com.delivery.domain.enums.UserEnum;
import lombok.*;

@Builder
public record UserInputDTO(String fullname, String email, String password, String phone, UserEnum level) {
}
