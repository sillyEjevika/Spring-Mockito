package ru.sillyEjevika.repository.impl;

import ru.sillyEjevika.model.User;
import ru.sillyEjevika.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    public static final List<User> users = new ArrayList<>();

    public UserRepositoryImpl() {
        users.add(new User("Vika"));
        users.add(new User("Viktoria"));
        users.add(new User("Vikiwna"));
    }

    @Override
    public User getUserByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
