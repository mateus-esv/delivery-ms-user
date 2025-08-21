package com.delivery.api.dto;

import com.delivery.domain.enums.UserEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserOutputDTO {

    private String nome;
    private String email;
    private String celular;
    private UserEnum nivel;

}
