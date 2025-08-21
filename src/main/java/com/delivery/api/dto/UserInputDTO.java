package com.delivery.api.dto;

import com.delivery.domain.enums.UserEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInputDTO {

    private String nome;
    private String email;
    private String celular;
    private UserEnum nivel;

}
