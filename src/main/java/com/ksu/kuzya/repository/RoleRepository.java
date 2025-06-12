package com.ksu.kuzya.repository;

import com.ksu.kuzya.entities.Role;
import com.ksu.kuzya.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
