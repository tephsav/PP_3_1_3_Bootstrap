package ru.kata.spring.boot_bootstrap.demo.service;

import ru.kata.spring.boot_bootstrap.demo.model.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);

    Role getRoleByName(String name);

    List<Role> getRoles();
}
