package ru.practicum.shareit.item.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.item.dto.*;
import ru.practicum.shareit.item.service.ItemService;
import ru.practicum.shareit.item.storage.ItemStorage;

import java.util.List;

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
    public ItemWithBookingsResponseDto getItemById(Long itemId, Long userId) {
        return itemStorage.getItemById(itemId, userId);
    }

    @Override
    public List<ItemWithBookingsResponseDto> getUserItems(Long userId) {
        return itemStorage.getUserItems(userId);
    }

    @Override
    public List<ItemResponseDto> searchItemsByText(String text, Long userId) {
        return itemStorage.searchItemsByText(text, userId);
    }

    @Override
    public CommentResponseDto postComment(Long userId, Long itemId, CommentRequestDto commentRequestDto) {
        return itemStorage.postComment(userId, itemId, commentRequestDto);
    }
}
