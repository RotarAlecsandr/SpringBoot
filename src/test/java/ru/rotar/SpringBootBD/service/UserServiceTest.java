package ru.rotar.SpringBootBD.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rotar.SpringBootBD.model.User;
import ru.rotar.SpringBootBD.repositories.UserRepositories;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepositories userRepositories;
    @InjectMocks
    private UserService userService;


    @Test
    void findAll() {
        userService.findAll();
    }

    @Test
    void findOne() {
        userService.findOne(1);
    }

    @Test
    void saveUser() {
        User user = new User();
        userService.saveUser(user);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(1);
    }
}