package com.ksu.kuzya.controller;

import com.ksu.kuzya.DTO.UserDTO;
import com.ksu.kuzya.entities.User;
import com.ksu.kuzya.repository.UserRepository;
import com.ksu.kuzya.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registrationForm(){
        return "registration";
    }

    @PostMapping
    public String processRegistration(UserDTO dto){
        userService.saveUser(dto);
        return "redirect:/login";
    }

}
