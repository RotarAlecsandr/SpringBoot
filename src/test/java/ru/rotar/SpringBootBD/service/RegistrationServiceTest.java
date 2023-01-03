package ru.rotar.SpringBootBD.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rotar.SpringBootBD.model.Person;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {

    @Mock
    private RegistrationService registrationService;

    @Test
    void register() {
        Person person = new Person();
        registrationService.register(person);
    }
}