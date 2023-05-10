package ru.sillyEjevika.repository;

import ru.sillyEjevika.model.User;

import java.util.List;

public interface UserRepository {
    User getUserByName(String name);
    List<User> getAllUsers();
}
