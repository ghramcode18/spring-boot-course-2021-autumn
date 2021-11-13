package org.closure.course.service;

import org.closure.course.entity.User;
import org.closure.course.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    MailService mailService;

    @Transactional
    public User registerUser(User user) {
        user = userRepo.save(user.withActive(false));
        mailService.authEmail(user.getEmail(), "thanks for register in our platform",
                "please verify your email by this link : \nhttp://localhost:8080/api/v1/user/verify/" + user.getId());
        return user;
    }

    public String verify(Integer id) throws Exception {
        User user = userRepo.findById(id).orElseThrow(() -> new Exception("no user with this id"));
        user.setActive(true);
        userRepo.save(user);
        return "user with id : " + id + "is verified";
    }

    public User userInfo(Integer id) throws Exception {
        return userRepo.findById(id).orElseThrow(() -> new Exception("no user with this id"));
    }
}
