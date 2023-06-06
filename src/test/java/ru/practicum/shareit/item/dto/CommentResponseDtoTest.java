package ru.practicum.shareit.item.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class CommentResponseDtoTest {

    @Test
    void testConstructor() {
        CommentResponseDto actualCommentResponseDto = new CommentResponseDto();
        actualCommentResponseDto.setAuthorName("JaneDoe");
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualCommentResponseDto.setCreated(ofResult);
        actualCommentResponseDto.setId(1L);
        actualCommentResponseDto.setText("Text");
        assertEquals("JaneDoe", actualCommentResponseDto.getAuthorName());
        assertSame(ofResult, actualCommentResponseDto.getCreated());
        assertEquals(1L, actualCommentResponseDto.getId().longValue());
        assertEquals("Text", actualCommentResponseDto.getText());
    }
}
