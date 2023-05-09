package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.item.dto.ItemRequestDto;
import ru.practicum.shareit.item.dto.ItemResponseDto;
import ru.practicum.shareit.item.service.ItemService;
import ru.practicum.shareit.validation.ForCreate;

import javax.validation.constraints.Positive;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ItemResponseDto createItem(@RequestBody @Validated(ForCreate.class) ItemRequestDto itemRequestDto,
                                      @Positive @RequestHeader("X-Sharer-User-Id") Long userId) {
        log.info("Запрос на получение предмета по id = {}", userId);
        return itemService.addItem(itemRequestDto, userId);
    }

    @PatchMapping("/{itemId}")
    public ItemResponseDto updateItem(@PathVariable Long itemId,
                                      @RequestBody ItemRequestDto itemRequestDto,
                                      @Positive @RequestHeader("X-Sharer-User-Id") Long userId) {
        log.info("Запрос на изменение данных о предмете с id = {}", itemId);
        return itemService.updateItem(itemId, itemRequestDto, userId);
    }

    @GetMapping("/{itemId}")
    public ItemResponseDto getItemById(@PathVariable Long itemId,
                                       @Positive @RequestHeader("X-Sharer-User-Id") Long userId) {
        log.info("Запрос на получение предмета по id = {}", itemId);
        return itemService.getItemById(itemId, userId);
    }

    @GetMapping
    public List<ItemResponseDto> getUserItems(@Positive @RequestHeader("X-Sharer-User-Id") Long userId) {
        log.info("Запрос на получение предметов пользователя по id = {}", userId);
        return itemService.getUserItems(userId);
    }

    @GetMapping("/search")
    public List<ItemResponseDto> searchItemsByText(@RequestParam String text,
                                                   @Positive @RequestHeader("X-Sharer-User-Id") Long userId) {
        log.info("Запрос на поиск предметов по строке = {}", text);
        return itemService.searchItemsByText(text, userId);
    }
}