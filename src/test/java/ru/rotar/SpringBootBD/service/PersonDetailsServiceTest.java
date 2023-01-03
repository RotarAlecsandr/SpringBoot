package ru.rotar.SpringBootBD.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonDetailsServiceTest {

    @Mock
    private PersonDetailsService personDetailsService;

    @Test
    void loadUserByUsername() {
        personDetailsService.loadUserByUsername("Hello world");
    }
}