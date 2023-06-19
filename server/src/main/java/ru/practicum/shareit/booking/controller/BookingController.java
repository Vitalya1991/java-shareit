package ru.practicum.shareit.booking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.booking.dto.BookItemRequestDto;
import ru.practicum.shareit.booking.dto.BookingResponseDto;
import ru.practicum.shareit.booking.service.BookingService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingServiceImpl;
    private final String header = "X-Sharer-User-Id";

    @PostMapping
    public BookingResponseDto addBooking(@Valid @RequestBody BookItemRequestDto itemRequestDto,
                                         @Positive @RequestHeader(header) Long userId) {
        return bookingServiceImpl.addBooking(itemRequestDto, userId);
    }

    @PatchMapping("/{bookingId}")
    public BookingResponseDto updateBooking(@RequestHeader(header) Long userId,
                                            @Positive @PathVariable Long bookingId,
                                            @RequestParam Boolean approved) {
        return bookingServiceImpl.updateBooking(userId, bookingId, approved);
    }

    @GetMapping("/{bookingId}")
    public BookingResponseDto getBookingOnlyForOwnerOrBooker(@Positive @PathVariable Long bookingId,
                                                             @Positive @RequestHeader(header) Long userId) {
        return bookingServiceImpl.getBookingOnlyForOwnerOrBooker(userId, bookingId);
    }


    @GetMapping
    public Iterable<BookingResponseDto> getBookingsByUserId(@RequestParam(defaultValue = "0") @PositiveOrZero Integer from,
                                                            @Positive @RequestParam(defaultValue = "10") Integer size,
                                                            @Positive @RequestHeader(header) Long userId,
                                                            @RequestParam(defaultValue = "ALL") String state) {
        return bookingServiceImpl.getBookingsByUserId(userId, state, from, size);
    }

    @GetMapping("/owner")
    public Iterable<BookingResponseDto> getBookingsByOwnerId(
            @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
            @Positive @RequestParam(defaultValue = "10") Integer size,
            @Positive @RequestHeader(header) Long userId,
            @RequestParam(defaultValue = "ALL") String state) {
        return bookingServiceImpl.getBookingsByOwnerId(from, size, userId, state);
    }
}