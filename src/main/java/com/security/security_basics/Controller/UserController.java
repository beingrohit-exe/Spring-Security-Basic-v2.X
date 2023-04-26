package com.security.security_basics.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.security_basics.Entity.User;
import com.security.security_basics.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String addUser(@RequestBody User user){
        String addUser = userService.addUser(user);
        return addUser;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        User addUser = userService.getUser(id);
        return addUser;
    }

    @GetMapping
    public List<User> getAll() {
        List<User> allUsers = userService.allUsers();
        return allUsers;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.removeUser(id);
    }
}
