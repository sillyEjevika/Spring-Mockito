package ru.sillyEjevika.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sillyEjevika.model.User;
import ru.sillyEjevika.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private static final User VALID_USER = new User("Vika");
    private static final User INVALID_USER = new User("Vikiwna");

    private static final List<User> users = List.of(
            VALID_USER,
            new User("Viktoria"),
            new User("Vikki")
    );

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("Возвращает true если пользователь с именем есть в списке")
    void shouldReturnTrueIfUserExists() {
        when(userRepository.getAllUsers())
                .thenReturn(users);

        assertEquals(users, userRepository.getAllUsers());
        assertTrue(userService.checkUserExist(VALID_USER));
    }

    @Test
    @DisplayName("Возвращает false если пользователя с именем нет в списке")
    void shouldReturnFalseIfUserNotExists() {
        when(userRepository.getAllUsers())
                .thenReturn(users);

        assertEquals(users, userRepository.getAllUsers());
        assertFalse(userService.checkUserExist(INVALID_USER));
    }
}