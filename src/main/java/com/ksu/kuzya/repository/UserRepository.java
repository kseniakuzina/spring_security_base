package com.ksu.kuzya.repository;

import com.ksu.kuzya.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}
