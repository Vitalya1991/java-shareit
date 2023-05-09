package ru.practicum.shareit.user.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.dto.UserMapper;
import ru.practicum.shareit.user.dto.UserRequestDto;
import ru.practicum.shareit.user.dto.UserResponseDto;

import java.util.*;

@Repository
@Slf4j
public class UserStorageImpl implements UserStorage {
    private final Map<Long, User> userMap = new HashMap<>();
    private Long id = 1L;

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = UserMapper.fromUserRequestDto(userRequestDto);
        checkUniqueEmail(user.getEmail(), id);
        user.setId(id);
        id++;
        getUserMap().put(user.getId(), user);
        log.debug("Пользователь с id= {} добавлен", user.getId());
        return UserMapper.toUserResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto, Long userId) {
        checkUserExistsById(userId);
        checkUniqueEmail(userRequestDto.getEmail(), userId);
        User user = userMap.get(userId);
        Optional.ofNullable(userRequestDto.getEmail()).ifPresent(user::setEmail);
        Optional.ofNullable(userRequestDto.getName()).ifPresent(user::setName);
        userMap.put(userId, user);
        log.debug("Обновлен пользователь с id = {}", userId);
        return UserMapper.toUserResponseDto(user);
    }


    @Override
    public UserResponseDto getUserById(Long userId) {
        checkUserExistsById(userId);
        log.debug("Получен пользователь с id = {}", userId);
        return UserMapper.toUserResponseDto(userMap.get(userId));
    }

    @Override
    public void deleteUserById(Long userId) {
        checkUserExistsById(userId);
        userMap.remove(userId);
        log.debug("Удален пользователь с id = {}", userId);
    }

    @Override
    public List<UserResponseDto> getUsers() {
        log.debug("Найдены все пользователи");
        return UserMapper.toUserResponseDtoList(userMap.values());
    }

    @Override
    public Map<Long, User> getUserMap() {
        return userMap;
    }

    private void checkUserExistsById(Long userId) {
        if (!userMap.containsKey(userId)) {
            throw new RuntimeException("Пользователя с таким id не существует");
        }
    }

    private void checkUniqueEmail(String email, Long userId) {
        for (User user : userMap.values()) {
            if (user.getEmail().equals(email)) {
                if (!Objects.equals(user.getId(), userId)) {
                    throw new RuntimeException("Пользователь с данной почтой уже зарегестрирован");
                }
            }
        }
    }
}
