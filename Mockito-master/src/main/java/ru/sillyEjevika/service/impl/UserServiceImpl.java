package ru.sillyEjevika.service.impl;

import ru.sillyEjevika.model.User;
import ru.sillyEjevika.repository.UserRepository;
import ru.sillyEjevika.repository.impl.UserRepositoryImpl;
import ru.sillyEjevika.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public boolean checkUserExist(User user) {
        List<User> allUsers = userRepository.getAllUsers();
        return allUsers.contains(user);
    }
}
