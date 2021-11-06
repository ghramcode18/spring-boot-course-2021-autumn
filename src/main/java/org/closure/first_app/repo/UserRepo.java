package org.closure.first_app.repo;

import java.util.Optional;

import org.closure.first_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    public Optional<User> findByPhoneAndPassword(Integer phone,String password);
    public Optional<User> findByPhone(Integer phone);
}
