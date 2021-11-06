package org.closure.first_app.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.closure.first_app.entity.User;
import org.closure.first_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(User user) {
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(User user) {
        return "register";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(User user, Model model) {
        model.addAttribute("user", user);
        return "home";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(User user, Model model) throws Exception {
        try {
            user = userService.signin(user.getPhone(), user.getPassword());
            model.addAttribute("user", user);
            return "home";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "errorpage";
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(User user, Model model) {
        try {
            userService.signup(user);
        } catch (Exception e) {
         model.addAttribute("error", e.getMessage());
         return "errorpage";
        }
        model.addAttribute("user", user);
        return "home";

    }

}
