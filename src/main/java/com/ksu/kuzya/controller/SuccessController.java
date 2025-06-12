package com.ksu.kuzya.controller;

import com.ksu.kuzya.DTO.UserDTO;
import com.ksu.kuzya.entities.Task;
import com.ksu.kuzya.service.TaskService;
import com.ksu.kuzya.service.UserService;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/success")
public class SuccessController {
    private UserService userService;
    private TaskService taskService;

    public SuccessController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping
    public String success(Model model) {
        String username = userService.getCurrentUsername();
        var tr = userService.getCurrentUser().getAuthorities();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority authority : tr) {
            System.out.println(authority.getAuthority());
            roles.add(authority.getAuthority());
        }
        model.addAttribute("username", username);
        model.addAttribute("roles", roles);
        return "success";
    }


    @GetMapping("/tasks")
    public String taskList(Model model){
        List<Task> tasks = taskService.findTasksByUserId(userService.getUserIdByUsername(userService.getCurrentUsername()));
        for (Task task : tasks){
            System.out.println(task.getName());
        }
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
}
