package com.delivery.api.dto;

import com.delivery.domain.enums.UserEnum;
import lombok.Builder;

@Builder
public record UserOutputDTO(String fullname, String email, String phone, UserEnum level) {
}
