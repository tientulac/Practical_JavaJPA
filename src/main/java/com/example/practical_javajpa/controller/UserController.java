package com.example.practical_javajpa.controller;

import com.example.practical_javajpa.entity.User;
import com.example.practical_javajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users") // router
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "test")
    public String getList() {
        return "Hello world !";
    }

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User update(@RequestBody User updateUser) {
        User user = userService.findById(updateUser.getUserID());
        if (user != null) {
            user.setAge(updateUser.getAge());
            user.setName(updateUser.getName());
            user.setSalary(updateUser.getSalary());
            userService.update(user);
        }
        return user;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        return userService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public HashMap<String, Object> getList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("page", page);
        response.put("limit", limit);
        response.put("data", userService.findAll());
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, path = "search")
    public HashMap<String, Object> search(@RequestBody User user, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        List<User> listSearch = new ArrayList<>();
        listSearch = userService.search(user);
        HashMap<String, Object> response = new HashMap<>();
        response.put("page", page);
        response.put("limit", limit);
        response.put("data", listSearch);
        return response;
    }
}
