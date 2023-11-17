package ru.kata.spring.boot_bootstrap.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_bootstrap.demo.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public String userPage(Model model) {
        String userName = userService.getCurrentUserName();
        model.addAttribute("user", userService.getUserByName(userName));
        return "userPage";
    }
}
