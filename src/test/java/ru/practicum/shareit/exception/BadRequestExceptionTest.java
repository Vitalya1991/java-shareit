package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BadRequestExceptionTest {

    @Test
    void testConstructor() {
        BadRequestException actualBadRequestException = new BadRequestException("An error occurred");
        assertNull(actualBadRequestException.getCause());
        assertEquals(0, actualBadRequestException.getSuppressed().length);
        assertEquals("An error occurred", actualBadRequestException.getMessage());
        assertEquals("An error occurred", actualBadRequestException.getLocalizedMessage());
    }
}
