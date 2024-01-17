package org.example.furama4.service.role;

import org.example.furama4.model.role.User;
import org.example.furama4.repository.role.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo iUserRepo;

    @Override
    public void create(User user) {
        iUserRepo.save(user);
    }

    @Override
    public void update(User user) {
        iUserRepo.save(user);
    }

    @Override
    public void deleteByUserName(String username) {
        iUserRepo.deleteById(username);
    }

    @Override
    public List< User > findAll() {
        return iUserRepo.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return iUserRepo.findById(username).orElse(null);
    }
}
