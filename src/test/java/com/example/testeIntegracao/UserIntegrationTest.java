package com.example.testeIntegracao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
// Sobe o contexto completo da aplicação (Spring, JPA, Hibernate etc.)
@ActiveProfiles("test")
// Garante que esta sendo usado as configurações do ambiente de teste (ex: H2)
class UserIntegrationTest {

    @Autowired // Injeta o repositório REAL (não é mock)
    private UserRepository repository;

    @Test
    void deveSalvarUsuarioNoBanco() {

        User user = new User("Henrique"); // Criamos um usuario real para persistência

        repository.save(user); //dado salvo no banco h2

        List<User> usuarios = repository.findAll(); //busca dados reais para validacao

       // assertFalse(usuarios.isEmpty());
        assertTrue(usuarios.isEmpty());
    }
}