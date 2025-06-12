package com.ksu.kuzya.controller;

import com.ksu.kuzya.DTO.TaskDTO;
import com.ksu.kuzya.entities.Role;
import com.ksu.kuzya.entities.User;
import com.ksu.kuzya.service.TaskService;
import com.ksu.kuzya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("success/manager")
public class ManagerController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String managerPage(Model model) {
        return "manager";
    }

    @PostMapping
    public String saveTask(TaskDTO dto) {
        taskService.saveTask(dto);
        return "redirect:/success/manager";
    }

}