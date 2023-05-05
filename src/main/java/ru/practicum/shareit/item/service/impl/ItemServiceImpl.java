package ru.practicum.shareit.item.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.item.dto.ItemMapper;
import ru.practicum.shareit.item.dto.ItemRequestDto;
import ru.practicum.shareit.item.dto.ItemResponseDto;
import ru.practicum.shareit.item.exceptions.ItemNotFoundException;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.item.service.ItemService;
import ru.practicum.shareit.item.storage.ItemStorage;
import ru.practicum.shareit.user.exceptions.UserNotFoundException;
import ru.practicum.shareit.user.service.UserService;
import ru.practicum.shareit.user.storage.UserStorage;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemStorage itemStorage;

    @Override
    public ItemResponseDto addItem(ItemRequestDto itemRequestDto, Long userId) {
        return itemStorage.addItem(itemRequestDto, userId);
    }

    @Override
    public ItemResponseDto updateItem(Long itemId, ItemRequestDto itemRequestDto, Long userId) {
        return itemStorage.updateItem(itemId, itemRequestDto, userId);
    }

    @Override
    public ItemResponseDto getItemById(Long itemId, Long userId) {
        return itemStorage.getItemById(itemId, userId);
    }

    @Override
    public List<ItemResponseDto> getUserItems(Long userId) {
        return itemStorage.getUserItems(userId);
    }

    @Override
    public List<ItemResponseDto> searchItemsByText(String text, Long userId) {
        return itemStorage.searchItemsByText(text, userId);
    }
}
