package ru.practicum.shareit.item.model;

import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.request.ItemRequest;
import ru.practicum.shareit.user.User;
import lombok.Builder;

@Getter
@Setter
@Builder
public class Item {
    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private User owner;
    private ItemRequest request;
}