package com.nttdata.hotelapp.repository;


import com.nttdata.hotelapp.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
}
