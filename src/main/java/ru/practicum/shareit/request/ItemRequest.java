package ru.practicum.shareit.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemRequest {
    private int id;
    private String description;
    private String requestor;
    private LocalDateTime created;
}