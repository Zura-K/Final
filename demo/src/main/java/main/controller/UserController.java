package main.controller;

import main.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import main.services.UserServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImplementation userServiceImplementation;

    @GetMapping
    public List<User> getAllUsers() {
        return userServiceImplementation.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userServiceImplementation.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userServiceImplementation.addUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userServiceImplementation.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userServiceImplementation.deleteUser(id);
    }
}