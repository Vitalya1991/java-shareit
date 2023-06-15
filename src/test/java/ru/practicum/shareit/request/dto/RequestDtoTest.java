package ru.practicum.shareit.request.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestDtoTest {

    @Test
    void testConstructor() {
        RequestDto actualRequestDto = new RequestDto();
        actualRequestDto.setDescription("The characteristics of someone or something");
        assertEquals("The characteristics of someone or something", actualRequestDto.getDescription());
    }
}
