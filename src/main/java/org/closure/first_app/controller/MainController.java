package org.closure.first_app.controller;

import java.util.List;

import org.closure.first_app.entity.Employee;
import org.closure.first_app.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Autowired
    EmployeeRepo employeeRepo;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "home";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }
}
