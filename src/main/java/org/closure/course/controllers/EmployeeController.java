package org.closure.course.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @RequestMapping(path = { "/greeting" },method = RequestMethod.GET)
    public String welcomePage() {
        return "Welcome!";
    }
}