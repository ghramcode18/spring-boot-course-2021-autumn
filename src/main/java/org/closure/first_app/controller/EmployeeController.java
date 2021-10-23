package org.closure.first_app.controller;

import org.closure.first_app.entity.Employee;
import org.closure.first_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/api/v1/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/add", method=RequestMethod.POST)
    @ResponseBody
    public Employee requestMethodName(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    
}
