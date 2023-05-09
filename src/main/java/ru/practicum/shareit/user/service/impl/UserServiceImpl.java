package ru.practicum.shareit.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.dto.UserRequestDto;
import ru.practicum.shareit.user.dto.UserResponseDto;
import ru.practicum.shareit.user.service.UserService;
import ru.practicum.shareit.user.storage.UserStorage;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserStorage userStorage;

    public UserServiceImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        return userStorage.addUser(userRequestDto);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto, Long userId) {
        return userStorage.updateUser(userRequestDto, userId);
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        return userStorage.getUserById(userId);
    }

    @Override
    public void deleteUserById(Long userId) {
        userStorage.deleteUserById(userId);
    }

    @Override
    public List<UserResponseDto> getUsers() {
        return userStorage.getUsers();
    }

    @Override
    public Map<Long, User> getUserMap() {
        return userStorage.getUserMap();
    }
}
