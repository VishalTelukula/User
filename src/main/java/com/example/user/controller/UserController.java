package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUser(@Argument Long id) {
        return userService.getUser(id).orElse(null);
    }

    @MutationMapping
    public User createUser(@Argument String fName, @Argument String lName,
                           @Argument String email) {
        User user = new User();
        user.setfName(fName);
        user.setlName(lName);
        user.setEmail(email);
        return userService.createUser(user);
    }
    @MutationMapping
    public void deleteUser(@Argument Long id){
        userService.deleteUser(id);
    }

}
