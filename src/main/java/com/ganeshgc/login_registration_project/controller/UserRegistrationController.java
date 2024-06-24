package com.ganeshgc.login_registration_project.controller;

import com.ganeshgc.login_registration_project.service.UserService;
import com.ganeshgc.login_registration_project.web.Dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
     userService.saveUser(userRegistrationDto);
        return "redirect:/registration?success";
    }
}
