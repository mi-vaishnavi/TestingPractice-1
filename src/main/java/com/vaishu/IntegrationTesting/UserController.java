package com.vaishu.IntegrationTesting;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public Users createUser(@Valid @RequestBody Users user) {
        return service.saveUser(user);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
        return "User deleted";
    }
}