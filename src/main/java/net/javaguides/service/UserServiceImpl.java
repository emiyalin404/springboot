package net.javaguides.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.entity.User;
import net.javaguides.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> searchUsers(String query) {
        List<User> users = userRepository.searchUsers(query);
        return users;
    }

}
