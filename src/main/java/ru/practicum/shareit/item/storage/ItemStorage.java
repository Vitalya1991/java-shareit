package ru.practicum.shareit.item.storage;

import ru.practicum.shareit.item.dto.ItemRequestDto;
import ru.practicum.shareit.item.dto.ItemResponseDto;

import java.util.List;

public interface ItemStorage {
    ItemResponseDto addItem(ItemRequestDto itemRequestDto, Long userId);

    ItemResponseDto updateItem(Long itemId, ItemRequestDto itemRequestDto, Long userId);

    ItemResponseDto getItemById(Long itemId, Long userId);

    List<ItemResponseDto> getUserItems(Long userId);

    List<ItemResponseDto> searchItemsByText(String text, Long userId);
}
