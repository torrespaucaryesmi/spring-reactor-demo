package com.nttdata.hotelapp.controller;

import com.nttdata.hotelapp.model.Booking;
import com.nttdata.hotelapp.model.Customer;
import com.nttdata.hotelapp.model.Payment;
import com.nttdata.hotelapp.model.Room;
import com.nttdata.hotelapp.service.BookingService;
import com.nttdata.hotelapp.service.CustomerService;
import com.nttdata.hotelapp.service.PaymentService;
import com.nttdata.hotelapp.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/hotels")
public class HotelController {

    private final BookingService bookingService;

    private final CustomerService customerService;

    private final RoomService roomService;

    private final PaymentService paymentService;

    // Booking endpoints
    @PostMapping("/bookings")
    public Mono<ResponseEntity<Booking>> createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/bookings")
    public Flux<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Customer endpoints
    @PostMapping("/customers")
    public Mono<ResponseEntity<Customer>> createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/customers")
    public Flux<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Room endpoints
    @PostMapping("/rooms")
    public Mono<ResponseEntity<Room>> createRoom(@RequestBody Room room) {
        return roomService.createRoom(room)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/rooms")
    public Flux<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    // Payment endpoints
    @PostMapping("/payments")
    public Mono<ResponseEntity<Payment>> createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/payments")
    public Flux<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
}