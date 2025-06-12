package com.ksu.kuzya.controller;

import com.ksu.kuzya.DTO.TaskDTO;
import com.ksu.kuzya.service.TaskService;
import com.ksu.kuzya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("success/curier")
public class CurierController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String curierPage(Model model) {
        return "curier";
    }

}