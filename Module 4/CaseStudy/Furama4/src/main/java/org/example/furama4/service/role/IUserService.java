package org.example.furama4.service.role;

import org.example.furama4.model.role.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserService {
    void create (User user);
    void update (User user);
    void deleteByUserName (String username);
    List<User> findAll();
    User findByUsername(String username);
}
