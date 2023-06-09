package ru.practicum.shareit.item.model;

import org.junit.jupiter.api.Test;
import ru.practicum.shareit.request.model.Request;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testConstructor() {
        Item actualItem = new Item();
        actualItem.setAvailable(true);
        actualItem.setDescription("The characteristics of someone or something");
        actualItem.setId(1L);
        actualItem.setName("Name");
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(1L);
        user.setName("Name");
        actualItem.setOwner(user);
        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setId(1L);
        user1.setName("Name");
        Request request = new Request();
        request.setDateTimeOfCreate(LocalDateTime.of(1, 1, 1, 1, 1));
        request.setDescription("The characteristics of someone or something");
        request.setId(1L);
        request.setRequester(user1);
        actualItem.setRequest(request);
        assertTrue(actualItem.getAvailable());
        assertEquals("The characteristics of someone or something", actualItem.getDescription());
        assertEquals(1L, actualItem.getId().longValue());
        assertEquals("Name", actualItem.getName());
        assertSame(user, actualItem.getOwner());
        assertSame(request, actualItem.getRequest());
    }
}
