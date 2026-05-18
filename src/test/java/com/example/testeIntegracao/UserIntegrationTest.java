package com.example.testeIntegracao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@ActiveProfiles("test")
class UserIntegrationTest {

    @Autowired
    private UserRepository repository;

    @Test
    void deveSalvarUsuarioNoBanco() {

        User user = new User("Henrique");

        repository.save(user);

        List<User> usuarios = repository.findAll();

        assertFalse(usuarios.isEmpty());
    }
}