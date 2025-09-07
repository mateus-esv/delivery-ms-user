package com.delivery.domain.entity;

import com.delivery.domain.enums.UserEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "tb_user")
public class User {

    @Id
    @Column(unique = true, name = "id")
    private UUID id;
    @Column(name = "full_name")
    private String fullName;
    @Column(unique = true, name = "email")
    private String email;
    @Column(unique = true, name = "phone")
    private String phone;
    @Column(name = "level")
    private UserEnum level;

}
