package org.closure.first_app.controller;

import java.util.List;

import org.closure.first_app.dto.UserDto;
import org.closure.first_app.entity.User;
import org.closure.first_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/add", method=RequestMethod.POST)
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value="/all", method=RequestMethod.GET)
    @ResponseBody   
    public List<UserDto> getAll() {
        return userService.getUsers();
    }

    @RequestMapping(value="/custom", method=RequestMethod.GET)
    @ResponseBody   
    public List<User> getCustomUsers(@RequestParam int max) {
        return userService.getCustomUsers(max);
    }

    @RequestMapping(value="/delete", method=RequestMethod.DELETE)
    @ResponseBody   
    public void deleteUserById(@RequestParam int id) {
        userService.deleteUserById(id);
    }
    
}
