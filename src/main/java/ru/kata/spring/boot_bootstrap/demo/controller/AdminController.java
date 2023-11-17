package ru.kata.spring.boot_bootstrap.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_bootstrap.demo.model.Role;
import ru.kata.spring.boot_bootstrap.demo.model.User;
import ru.kata.spring.boot_bootstrap.demo.service.RoleService;
import ru.kata.spring.boot_bootstrap.demo.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin")
    public String mainPage(Model model) {
        model.addAttribute("currentUser", userService.getUserByName(userService.getCurrentUserName()));
        model.addAttribute("newUser", new User());
        model.addAttribute("allUsers", userService.getUsers());
        model.addAttribute("allRoles", roleService.getRoles());
        return "adminPage";
    }

    @PostMapping(value = "/admin/edit")
    public String editUser(@ModelAttribute("u") User user,
                           @RequestParam("editRoles") List<String> listRoles) {
        Set<Role> roles = new HashSet<>();
        for (String role : listRoles) {
            roles.add(roleService.getRoleByName(role));
        }
        user.setRoles(roles);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/new")
    public String createUser(@ModelAttribute("newUser") User user,
                             @RequestParam("chooseRoles") List<String> listRoles) {
        Set<Role> roles = new HashSet<>();
        for (String role : listRoles) {
            roles.add(roleService.getRoleByName(role));
        }
        user.setRoles(roles);
        userService.addUser(user);
        return "redirect:/admin";
    }
}