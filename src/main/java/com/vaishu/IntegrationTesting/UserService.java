package com.vaishu.IntegrationTesting;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public Users saveUser(Users user) {
        return repo.save(user);
    }

    public List<Users> getAllUsers() {
        return repo.findAll();
    }

    public Users getUserById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Integer id) {
        repo.deleteById(id);
    }
}