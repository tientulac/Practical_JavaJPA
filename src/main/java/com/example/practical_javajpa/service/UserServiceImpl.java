package com.example.practical_javajpa.service;

import com.example.practical_javajpa.entity.User;
import com.example.practical_javajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        User user = userRepository.findById(id).get();
        if (user != null) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> search(User user) {
        return userRepository.searchUserByName(user.getName());
    }
}
