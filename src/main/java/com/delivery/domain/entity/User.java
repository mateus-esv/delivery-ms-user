package com.delivery.domain.entity;

import com.delivery.domain.enums.UserEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    private UUID id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String celular;
    private UserEnum nivel;


}
