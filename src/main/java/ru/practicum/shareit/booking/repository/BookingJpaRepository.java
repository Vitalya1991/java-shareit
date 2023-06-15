package ru.practicum.shareit.booking.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.practicum.shareit.booking.model.Booking;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookingJpaRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingByBookerId(@Param("bookerId") Long bookerId, Sort sort);

    List<Booking> findBookingByBookerIdAndStartIsBeforeAndEndIsAfter(@Param("bookerId") Long userId,
                                                                     @Param("time") LocalDateTime time1,
                                                                     @Param("time") LocalDateTime time2);

    List<Booking> findBookingByBookerIdAndStartIsBeforeAndEndIsBefore(@Param("bookerId") Long userId,
                                                                      @Param("time") LocalDateTime time1,
                                                                      @Param("time") LocalDateTime time2, Sort sort);
