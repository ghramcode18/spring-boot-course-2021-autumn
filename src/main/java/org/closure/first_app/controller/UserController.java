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
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(@RequestParam(name = "username") String name) {
        return "home";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(HttpServletRequest request, Model model) throws Exception {
        try {
            String name = userService.signin(request.getParameter("phone"), request.getParameter("password"));
            model.addAttribute("username", name);
            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(HttpServletRequest request, Model model) {

        User user = new User().withBill(Integer.parseInt(request.getParameter("bill")))
                .withName(request.getParameter("name")).withPassword(request.getParameter("password"))
                .withPhone(Integer.parseInt(request.getParameter("phone")));
        String name = userService.signup(user);
        model.addAttribute("username", name);
        return "redirect:/home";

    }

}
