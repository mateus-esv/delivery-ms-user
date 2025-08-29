package com.delivery.domain.service;

import com.delivery.api.dto.UserIDDTO;
import com.delivery.comuns.UserException;
import com.delivery.domain.entity.User;
import com.delivery.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repository;

    // Injeção via construtor (mais testável)
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        if (user == null) {
            logger.error("Tentativa de salvar usuário nulo");
            throw new UserException("Usuário inválido.");
        }

        // Gera UUID apenas se não existir
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }

        Optional<User> existingEmail = repository.findByEmail(user.getEmail());
        Optional<User> existingPhone = repository.findByCelular(user.getPhone());

        if (existingEmail.isPresent() || existingPhone.isPresent()) {
            logger.warn("Tentativa de salvar usuário com email ou celular já existente: email={}, celular={}",
                    user.getEmail(), user.getPhone());
            throw new UserException("Cadastro inválido: email ou celular já cadastrado.");
        }

        User savedUser = repository.save(user);
        logger.info("Usuário salvo com sucesso: {}", savedUser.getId());
        return savedUser;

    }

    public User update(User user) {
        if (user == null || user.getId() == null) {
            logger.error("Tentativa de atualizar usuário inválido ou nulo");
            throw new UserException("Usuário inválido.");
        }

        // Busca usuário existente no banco
        User existingUser = repository.findById(user.getId())
                .orElseThrow(() -> new UserException("Usuário não encontrado."));

        // Valida email e celular
        repository.findByEmail(user.getEmail())
                .filter(u -> !u.getId().equals(user.getId()))
                .ifPresent(u -> {
                    logger.warn("Email já cadastrado para outro usuário: {}", user.getEmail());
                    throw new UserException("Email inválido.");
                });

        repository.findByCelular(user.getPhone())
                .filter(u -> !u.getId().equals(user.getId()))
                .ifPresent(u -> {
                    logger.warn("Celular já cadastrado para outro usuário: {}", user.getPhone());
                    throw new UserException("Celular inválido.");
                });

        // Atualiza campos (mantendo id)
        existingUser.setFullname(user.getFullname());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhone(user.getPhone());
        existingUser.setLevel(user.getLevel());

        User updatedUser = repository.save(existingUser);
        logger.info("Usuário atualizado com sucesso: {}", updatedUser.getId());
        return updatedUser;
    }

    public List<User> listAll() {
        return repository.findAll();
    }

    public User findById(UserIDDTO userIDDTO) {
        if (userIDDTO == null || userIDDTO.id() == null) {
            logger.error("ID do usuário inválido");
            throw new UserException("ID do usuário inválido.");
        }

        return repository.findById(userIDDTO.id())
                .orElseThrow(() -> {
                    logger.warn("Usuário não encontrado: {}", userIDDTO.id());
                    return new UserException("Usuário não encontrado.");
                });
    }
}
