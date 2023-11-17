package ru.kata.spring.boot_bootstrap.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_bootstrap.demo.dao.RoleDao;
import ru.kata.spring.boot_bootstrap.demo.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }
}
