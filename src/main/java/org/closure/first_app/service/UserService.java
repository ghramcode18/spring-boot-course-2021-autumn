package org.closure.first_app.service;

import java.util.Date;
import java.util.List;

import org.closure.first_app.dto.UserDto;
import org.closure.first_app.entity.User;
import org.closure.first_app.model.EmployeeModel;
import org.closure.first_app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User addUser(User user) {
        user.setCreateAt(new Date());
        return userRepo.save(user);
    }

    public List<UserDto> getUsers() {
        return listUsersToDtos(userRepo.findAll());
    }

    public List<User> getCustomUsers(int max) {
        List<User> users = userRepo.findAll();
        return users.stream().filter((item) -> (item.getId() <= max)).toList();
    }

    public void deleteUserById(int id) {
        userRepo.findById(id).ifPresent((user) -> userRepo.delete(user));
    }

    private UserDto userToDto(User user) {
        UserDto userDto = new UserDto().createAt(user.getCreateAt()).id(user.getId()).name(user.getName())
                .email(user.getEmail()).password(user.getPassword());
        if (user.getEmployee() != null) {
            userDto.employee(new EmployeeModel().id(user.getEmployee().getId()).salary(user.getEmployee().getSalary())
                    .workingHours(user.getEmployee().getWorkingHours()));
            return userDto;
        } else
            return userDto;
    }

    private List<UserDto> listUsersToDtos(List<User> users) {
        return users.stream().map((user) -> userToDto(user)).toList();
    }
}
