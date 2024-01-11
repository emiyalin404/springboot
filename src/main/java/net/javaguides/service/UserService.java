package net.javaguides.service;

import java.util.List;

import net.javaguides.entity.User;

public interface UserService {
    List<User> searchUsers(String query);

    User createUser(User user);

}
