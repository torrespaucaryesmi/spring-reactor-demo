package com.nttdata.hotelapp.service;


import com.nttdata.hotelapp.model.Booking;
import com.nttdata.hotelapp.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public Mono<Booking> createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Mono<Booking> updateBooking(Long id, Booking booking) {
        booking.setId(id);
        return bookingRepository.save(booking);
    }

    public Mono<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Flux<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Mono<Void> deleteBooking(Long id) {
        return bookingRepository.deleteById(id);
    }
}