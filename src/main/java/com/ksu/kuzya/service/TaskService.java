package com.ksu.kuzya.service;

import com.ksu.kuzya.DTO.TaskDTO;
import com.ksu.kuzya.entities.Task;
import com.ksu.kuzya.entities.User;
import com.ksu.kuzya.repository.TaskRepository;
import com.ksu.kuzya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;

    @Transactional
    public boolean saveTask(TaskDTO dto) {
        System.out.println(dto.getUsername());
        User userFromDB = userRepository.findByUsername(dto.getUsername());

        if (userFromDB == null) {
            System.out.println("пользователя нет");
            return false;
        }
        System.out.println("сохраняем");
        Task task = new Task(userFromDB,dto.getName(),dto.getDescription());
        taskRepository.save(task);
        return true;
    }

    public List<Task> findTasksByUserId(Long id) {
        return taskRepository.findByUserId(id);
    }

}