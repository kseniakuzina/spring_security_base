package com.ksu.kuzya.repository;

import com.ksu.kuzya.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUserId(Long userId);
}
