package ru.practicum.shareit.item.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommentRequestDtoTest {

    @Test
    void testConstructor() {
        CommentRequestDto actualCommentRequestDto = new CommentRequestDto();
        actualCommentRequestDto.setText("Text");
        assertEquals("Text", actualCommentRequestDto.getText());
    }
}