package ru.practicum.shareit.user.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRequestDtoTest {

    @Test
    void testConstructor() {
        UserRequestDto actualUserRequestDto = new UserRequestDto();
        actualUserRequestDto.setEmail("jane.doe@example.org");
        actualUserRequestDto.setName("Name");
        assertEquals("jane.doe@example.org", actualUserRequestDto.getEmail());
        assertEquals("Name", actualUserRequestDto.getName());
    }

    @Test
    void testConstructorSecond() {
        UserRequestDto actualUserRequestDto = new UserRequestDto("Name", "jane.doe@example.org");
        actualUserRequestDto.setEmail("jane.doe@example.org");
        actualUserRequestDto.setName("Name");
        assertEquals("jane.doe@example.org", actualUserRequestDto.getEmail());
        assertEquals("Name", actualUserRequestDto.getName());
    }
}
