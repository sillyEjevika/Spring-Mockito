package ru.sillyEjevika.repository.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sillyEjevika.model.User;
import ru.sillyEjevika.repository.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private static final User VALID_USER = new User("Vika");
    private static final User INVALID_USER = new User("Vikiwna");
    private static final List<User> users = List.of(
            VALID_USER,
            new User("Viktoria"),
            new User("Vikki")
    );
    private static final UserRepository userRepository = new UserRepositoryImpl();

    @Test
    @DisplayName("Возвращает пользователя из списка по имени")
    void shouldGetUserByName() {
        assertEquals(VALID_USER, userRepository.getUserByName(VALID_USER.getName()));
    }

    @Test
    @DisplayName("Возвращает null по имени, которого нет в списке с пользователями")
    void shouldGetNullFromMethodGetUserByName() {
        assertNull(userRepository.getUserByName(INVALID_USER.getName()));
    }

    // Тесты от себя
    @Test
    @DisplayName("Возвращает список с пользователями")
    void shouldGetUsersList() {
        assertEquals(users, userRepository.getAllUsers());
    }
}