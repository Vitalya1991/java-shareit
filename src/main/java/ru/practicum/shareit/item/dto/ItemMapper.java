package ru.practicum.shareit.item.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.item.model.Item;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class ItemMapper {
    public static ItemResponseDto toItemResponseDto(Item item) {
        return ItemResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .available(item.getAvailable())
                .requestId(item.getRequest() != null ? item.getRequest().getId() : null).build();
    }

    public static Item toItem(ItemRequestDto itemRequestDto) {
        return Item.builder()
                .id(itemRequestDto.getId())
                .name(itemRequestDto.getName())
                .description(itemRequestDto.getDescription())
                .available(itemRequestDto.getAvailable()).build();


    }

    public static List<ItemResponseDto> fromItemListToItemResponseDtoList(Collection<Item> itemList) {
        return itemList.stream()
                .map(ItemMapper::toItemResponseDto)
                .collect(Collectors.toList());
    }
}