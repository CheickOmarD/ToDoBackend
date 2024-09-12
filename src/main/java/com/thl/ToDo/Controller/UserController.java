package com.thl.ToDo.Controller;


import com.thl.ToDo.Entity.User;
import com.thl.ToDo.Exception.NotFoundException;
import com.thl.ToDo.Service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @GetMapping("/user")
    public List<User> fetchUserList() {
        return userService.fetchUserList();
    }


    @GetMapping("/user/{Id}")
    public User fetchUserById(@PathVariable("Id") Long userId)
            throws NotFoundException {
        return userService.fetchUserById(userId);
    }


    @DeleteMapping("/user/{Id}")
    public String deleteUserById(@PathVariable("Id") Long userId) {
        return userService.deleteUserById(userId);
    }


    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.update(user);

    }

    @PutMapping("/assign-role")
    public void assignRole(@RequestBody User user) {
        userService.assignRole(user);
    }

}
