package ru.practicum.shareit.booking.model;

import org.junit.jupiter.api.Test;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.request.model.Request;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class BookingTest {

    @Test
    void testConstructor() {
        Booking actualBooking = new Booking();
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(1L);
        user.setName("Name");
        actualBooking.setBooker(user);
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualBooking.setEnd(ofResult);
        actualBooking.setId(1L);
        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setId(1L);
        user1.setName("Name");
        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setId(1L);
        user2.setName("Name");
        Request request = new Request();
        request.setDateTimeOfCreate(LocalDateTime.of(1, 1, 1, 1, 1));
        request.setDescription("The characteristics of someone or something");
        request.setId(1L);
        request.setRequester(user2);
        Item item = new Item();
        item.setAvailable(true);
        item.setDescription("The characteristics of someone or something");
        item.setId(1L);
        item.setName("Name");
        item.setOwner(user1);
        item.setRequest(request);
        actualBooking.setItem(item);
        LocalDateTime ofResult1 = LocalDateTime.of(1, 1, 1, 1, 1);
        actualBooking.setStart(ofResult1);
        actualBooking.setStatus(Booking.Status.WAITING);
        assertSame(user, actualBooking.getBooker());
        assertSame(ofResult, actualBooking.getEnd());
        assertEquals(1L, actualBooking.getId().longValue());
        assertSame(item, actualBooking.getItem());
        assertSame(ofResult1, actualBooking.getStart());
        assertEquals(Booking.Status.WAITING, actualBooking.getStatus());
    }
}
