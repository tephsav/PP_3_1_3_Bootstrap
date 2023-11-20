package ru.kata.spring.boot_bootstrap.demo.service;

import ru.kata.spring.boot_bootstrap.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void addUser(User user);

    void deleteUserById(Long id);

    void updateUser(User user);

    User getUserByName(String name);

    String getCurrentUserName();
}
