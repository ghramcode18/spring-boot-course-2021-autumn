package org.closure.first_app.service;

import org.closure.first_app.entity.User;
import org.closure.first_app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public String signin(String phone, String password) throws Exception {
        return userRepo.findByPhoneAndPassword(Integer.parseInt(phone), password)
                .orElseThrow(() -> new Exception("no user with this info")).getName();
    }
    public String signup(User user){
        user = userRepo.save(user);
        return user.getName();
    }
}
