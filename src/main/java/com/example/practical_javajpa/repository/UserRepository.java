package com.example.practical_javajpa.repository;

import com.example.practical_javajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.Name LIKE %:name%")
    List<User> searchUserByName(String name);
}
