package org.closure.course.controller;

import org.closure.course.entity.User;
import org.closure.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(value = "/api/v1/user")
public class userController {
    

    @Autowired
    UserService userService;

    @PostMapping(value="/add")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping(value="/verify/{id}")
    public String verifyUser(@PathVariable Integer id) throws Exception {
        return userService.verify(id);
    }

    @GetMapping(value="/{id}")
    public User userInfo(@PathVariable Integer id) throws Exception{
        return userService.userInfo(id);
    }
    
    
    
}
