package org.closure.first_app.service;

import org.closure.first_app.entity.User;
import org.closure.first_app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User signin(Integer phone, String password) throws Exception {
        return userRepo.findByPhoneAndPassword(phone, password)
                .orElseThrow(() -> new Exception("no user with this info"));
    }

    public User signup(User user) throws Exception {
        if (userRepo.findByPhone(user.getPhone()).isPresent())
            throw new Exception("this user already exist");
        return userRepo.save(user);
    }
}
