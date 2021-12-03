package org.closure.course.controllers;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @RequestMapping(path = { "/greeting" },method = RequestMethod.GET)
    public String welcomePage(Principal principal) {
        
        return "Welcome! "+principal.getName()+" : "+SecurityContextHolder.getContext().getAuthentication().getCredentials();
    }
}