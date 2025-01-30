package com.nttdata.hotelapp.repository;


import com.nttdata.hotelapp.model.Payment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends ReactiveCrudRepository<Payment, Long> {
}