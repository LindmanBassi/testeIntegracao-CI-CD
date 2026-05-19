package com.example.testeIntegracao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
// Ativa o suporte do Mockito no JUnit 5, permitindo criar mocks automaticamente
class UserServiceTest {

    @Mock
    // Cria um mock do repository (não acessa banco real)
    private UserRepository repository;

    @InjectMocks
    // Injeta automaticamente o mock dentro do UserService
    // O service "pensa" que esta usando o repository real
    private UserService service;

    @Test
    void deveSalvarUsuario() {

        User user = new User("Henrique"); // Criacao de um usuario para teste

        when(repository.save(any())) // Simulamos o comportamento do repository
                .thenReturn(user);    // quando salvar qualquer usuario, retorna o próprio objeto criado

        User salvo = service.salvar(user);  // Executa a logica real do service

        assertEquals("Henrique", salvo.getNome());  // Verifica se a logica do service funcionou corretamente
        //assertEquals("Thiago", salvo.getNome());
    }
}