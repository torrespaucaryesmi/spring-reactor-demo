package com.nttdata.hotelapp.repository;


import com.nttdata.hotelapp.model.Booking;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends ReactiveCrudRepository<Booking, Long> {
}