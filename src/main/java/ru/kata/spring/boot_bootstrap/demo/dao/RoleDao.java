package ru.kata.spring.boot_bootstrap.demo.dao;

import ru.kata.spring.boot_bootstrap.demo.model.Role;

import java.util.List;

public interface RoleDao {
    void save(Role role);

    Role getRoleByName(String name);

    List<Role> getRoles();
}
