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
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Test
    void deveSalvarUsuario() {

        User user = new User("Henrique");

        when(repository.save(any()))
                .thenReturn(user);

        User salvo = service.salvar(user);

        assertEquals("Henrique", salvo.getNome());
    }
}