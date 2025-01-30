package com.nttdata.hotelapp.service;

import com.nttdata.hotelapp.model.Customer;
import com.nttdata.hotelapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Mono<Customer> createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Mono<Customer> updateCustomer(Long id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public Mono<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Flux<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Mono<Void> deleteCustomer(Long id) {
        return customerRepository.deleteById(id);
    }
}