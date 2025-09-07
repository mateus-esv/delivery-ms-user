package com.delivery.domain.service;

import com.delivery.comuns.UserException;
import com.delivery.domain.entity.User;
import com.delivery.domain.enums.UserEnum;
import com.delivery.domain.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

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
        MockitoAnnotations.openMocks(this); // inicializa os mocks do Mockito
    }

    @Nested
    class Salvar {

        @Test
        void Dado_user_null_Quando_tentar_salvar_Entao_deve_lancar_excessao() {

            User userNull = null;

            UserException userException = Assertions
                    .assertThrows(UserException.class,
                            () -> userService.save(userNull));

            Assertions.assertEquals("Usuário inválido."
                    , userException.getMessage(),
                    "Lançou excessão ao tentar salvar usuário null");

        }

        @Test
        void Dado_user_com_id_null_Quando_tentar_salvar_Entao_deve_setar_uuid_para_o_id_do_user(){
            User userIdNull = User.builder()
                    .id(null)
                    .fullName("Mateus Elias Vieira")
                    .email("mateusifg16@gmail.com")
                    .phone("64992240834")
                    .level(UserEnum.USER)
                    .build();

            // Mocka o save para retornar o mesmo usuário
            Mockito.when(repository.save(Mockito.any(User.class))).thenReturn(userIdNull);

            userService.save(userIdNull);

            assertNotNull(userIdNull.getId(), "O UUID deveria ter sido gerado");

        }


    }


}