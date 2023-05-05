package ru.practicum.shareit.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.shareit.item.model.Item;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    @NotBlank(message = "Имя или логин пользователя отсутствует или передана пустая строка")
    private String name;
    @NotBlank(message = "Адрес электронной почты пользователя отсутствует или передана пустая строка")
    @Email(message = "Email пользователя указан некорректно")
    private String email;
    private final Map<Long, User> User = new HashMap<>();
}