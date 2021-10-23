package org.closure.first_app.service;

import org.closure.first_app.entity.Employee;
import org.closure.first_app.entity.User;
import org.closure.first_app.repo.EmployeeRepo;
import org.closure.first_app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    UserRepo userRepo;

    public Employee addEmployee(Employee employee) {
        // return employeeRepo.save(employee);
        Employee emp = employeeRepo.save(employee);

        User user = userRepo.findById(employee.getUser().getId()).get().employee(emp);
        userRepo.save(user);
        return emp;
    }
}
