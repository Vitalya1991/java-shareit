package ru.practicum.shareit.booking.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class BookItemRequestDtoTest {

    @Test
    void testConstructor() {
        BookItemRequestDto actualBookItemRequestDto = new BookItemRequestDto();
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualBookItemRequestDto.setEnd(ofResult);
        actualBookItemRequestDto.setItemId(1L);
        LocalDateTime ofResult1 = LocalDateTime.of(1, 1, 1, 1, 1);
        actualBookItemRequestDto.setStart(ofResult1);
        assertSame(ofResult, actualBookItemRequestDto.getEnd());
        assertEquals(1L, actualBookItemRequestDto.getItemId().longValue());
        assertSame(ofResult1, actualBookItemRequestDto.getStart());
    }
}
