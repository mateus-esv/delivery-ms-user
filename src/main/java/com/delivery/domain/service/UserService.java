package com.delivery.domain.service;

import com.delivery.api.dto.UserIDDTO;
import com.delivery.comuns.UserException;
import com.delivery.domain.entity.User;
import com.delivery.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void save(User user) {
        user.setId(UUID.randomUUID());
        if (!(repository.findByEmail(user.getEmail()).isPresent() || repository.findByCelular(user.getCelular()).isPresent())) {
            repository.saveAndFlush(user);
        } else {
            throw new UserException("Cadastro inválido.");
        }
    }

    public List<User> listAll() {
        return repository.findAll();
    }

    public User findById(UserIDDTO userIDDTO) {
        return repository.findById(userIDDTO.getId()).orElseThrow(()-> new UserException("Usuário não encontrado."));
    }

}
