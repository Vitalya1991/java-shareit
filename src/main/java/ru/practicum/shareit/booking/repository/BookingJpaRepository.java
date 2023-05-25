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

    List<Booking> findBookingByBookerIdAndStartIsAfter(@Param("bookerId") Long userId, @Param("time") LocalDateTime now, Sort sort);

    List<Booking> findBookingByBookerIdAndStatusEquals(@Param("bookerId") Long userId, @Param("status") Booking.Status status);

    Iterable<Booking> findAllByItemOwnerId(@Positive Long ownerId, Sort sort);

    Iterable<Booking> findBookingByItemOwnerIdAndStartIsBeforeAndEndIsAfter(@Param("ownerId") Long ownerId,
                                                                            @Param("time1") LocalDateTime time1,
                                                                            @Param("time2") LocalDateTime time2);

    Iterable<Booking> findBookingByItemOwnerIdAndEndIsBefore(@Param("ownerId") Long ownerId, @Param("time") LocalDateTime time, Sort sort);

    Iterable<Booking> findBookingByItemOwnerIdAndStartIsAfter(@Positive Long ownerId, LocalDateTime time, Sort sort);

    Iterable<Booking> findBookingByItemOwnerIdAndStatusEquals(@Positive Long ownerId, Booking.Status status);

    Optional<Booking> findFirstByItemIdAndStartIsBeforeOrderByEndDesc(@Positive Long itemId, LocalDateTime time);

    Optional<Booking> findFirstByItemIdAndStartIsAfterOrderByStart(@Positive Long itemId, LocalDateTime time);

    boolean existsByBookerIdAndItemIdAndEndIsBefore(@Positive Long userId, @Positive Long itemId, LocalDateTime time);

    List<Booking> findFirstByItemIdInAndEndIsBeforeOrderByEndDesc(@Positive List<Long> itemIds, LocalDateTime now);

    List<Booking> findFirstByItemIdInAndStartIsAfterOrderByStart(@Positive List<Long> itemIds, LocalDateTime now);


}