package com.nttdata.hotelapp.service;

import com.nttdata.hotelapp.model.Customer;
import com.nttdata.hotelapp.repository.api.NationalizeRepository;
import com.nttdata.hotelapp.repository.db.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final NationalizeRepository nationalizeRepository;

    public CustomerService(CustomerRepository customerRepository, NationalizeRepository nationalizeRepository) {
        this.customerRepository = customerRepository;
        this.nationalizeRepository = nationalizeRepository;
    }

    @Transactional
    public Mono<Customer> createCustomer(Customer customer) {
        return customerRepository.save(customer)
                .doOnSuccess(customerSaved -> nationalizeRepository.getNationalizeResponse(customerSaved.getName())
                        .flatMap(nationalize -> {
                            customerSaved.setCountry(nationalize.getCode());
                            return this.updateCustomer(customerSaved.getId(), customerSaved);
                        }).subscribe()
                );
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