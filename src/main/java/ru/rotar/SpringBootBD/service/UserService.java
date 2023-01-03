package ru.rotar.SpringBootBD.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rotar.SpringBootBD.model.User;
import ru.rotar.SpringBootBD.repositories.UserRepositories;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService  {
    private final UserRepositories userRepositories;

    public List<User> findAll() {
        return userRepositories.findAll();
    }

    public User findOne(int id) {
        return userRepositories.findById(id).orElse(null);
    }

    @Transactional
    public void saveUser(User user) {
        userRepositories.save(user);
    }

    @Transactional
    public void deleteUser(int id) {
        userRepositories.deleteById(id);
    }
}
