package ru.practicum.shareit.request.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.practicum.shareit.constants.HttpHeadersConstants;
import ru.practicum.shareit.request.dto.request.RequestItemRequestDto;
import ru.practicum.shareit.request.dto.response.ItemRequestResponseDto;

import javax.validation.Valid;
import java.util.List;

@Service
public class ItemRequestClient {
    private final WebClient client;
    private static final String API_PREFIX = "/requests";

    public ItemRequestClient(@Value("${shareit-server.url}") String serverUrl) {
        this.client = WebClient.create(serverUrl);
    }

    public ItemRequestResponseDto addItemRequest(@Valid RequestItemRequestDto requestDto, Long userId) {
        return client.post()
                .uri(API_PREFIX)
                .header(HttpHeadersConstants.X_SHARER_USER_ID, userId.toString())
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(ItemRequestResponseDto.class)
                .block();
    }

    public List<ItemRequestResponseDto> getItemRequestsByRequesterId(Long userId) {
        return client.get()
                .uri(API_PREFIX)
                .header(HttpHeadersConstants.X_SHARER_USER_ID, userId.toString())
                .retrieve()
                .bodyToFlux(ItemRequestResponseDto.class)
                .collectList()
                .block();
    }

    public ItemRequestResponseDto getItemRequestById(@Valid Long itemRequestId, Long userId) {
        return client.get()
                .uri("{/requests/id}", itemRequestId)
                .header(HttpHeadersConstants.X_SHARER_USER_ID, userId.toString())
                .retrieve()
                .bodyToMono(ItemRequestResponseDto.class)
                .block();
    }

    public List<ItemRequestResponseDto> getItemRequestsByRequesterId(@Valid Long userId, Integer from, Integer size) {
        return client.get()
                .uri(builder -> builder.path("/requests/all")
                        .queryParam("from", from)
                        .queryParam("size", size)
                        .build())
                .header(HttpHeadersConstants.X_SHARER_USER_ID, userId.toString())
                .retrieve()
                .bodyToFlux(ItemRequestResponseDto.class)
                .collectList()
                .block();
    }
}