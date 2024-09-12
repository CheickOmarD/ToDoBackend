package com.thl.ToDo.Service;

import com.thl.ToDo.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    List<User> fetchUserList();

    User fetchUserById(Long userId);

    String deleteUserById(Long userId);

    User update(User userDB);

    Optional<User> findById(Long userId);

    void assignRole(User user);

    User getAuthor();


}
