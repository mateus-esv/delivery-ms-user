package com.delivery.domain.service;

import com.delivery.domain.entity.User;
import com.delivery.domain.enums.UserEnum;
import com.delivery.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository repository;

    private User user;

    @BeforeEach
    void setUp() {
        // Executa antes de cada @Test
        user = User.builder()
                .id(UUID.randomUUID())
                .fullname("Mateus Elias Vieira")
                .email("mateusifg16@gmail.com")
                .password("senha@123")
                .phone("64992240834")
                .level(UserEnum.USER)
                .token("1223454535353454")
                .build();
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void listAll() {
    }

    @Test
    void findById() {
    }
}