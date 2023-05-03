package ru.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.user.dto.UserRequestDto;
import ru.practicum.shareit.user.dto.UserResponseDto;
import ru.practicum.shareit.user.service.UserService;
import ru.practicum.shareit.validation.ForCreate;
import ru.practicum.shareit.validation.ForUpdate;

import javax.validation.constraints.Positive;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponseDto addUser(@RequestBody @Validated(ForCreate.class) UserRequestDto userRequestDto) {
        log.info("Запрос на добавление пользователя");
        return userService.addUser(userRequestDto);
    }

    @PatchMapping("/{userId}")
    public UserResponseDto updateUser(@RequestBody @Validated(ForUpdate.class) UserRequestDto userRequestDto,
                                      @Positive @PathVariable Long userId) {
        log.info("Запрос на изменение пользователя");
        return userService.updateUser(userRequestDto, userId);
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUserById(@Positive @PathVariable Long userId) {
        log.info("Запрос на получение пользователя по id = {}", userId);
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@Positive @PathVariable Long userId) {
        log.info("Удаление пользователя по id = {}", userId);
        userService.deleteUserById(userId);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        log.info("Запрос на получение всех пользователей");
        return userService.getUsers();
    }
}