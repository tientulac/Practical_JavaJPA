package com.example.practical_javajpa.service;

import com.example.practical_javajpa.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User update(User user);

    List<User> findAll();

    boolean delete(int id);

    User findById(int id);

    List<User> search(User user);
}
