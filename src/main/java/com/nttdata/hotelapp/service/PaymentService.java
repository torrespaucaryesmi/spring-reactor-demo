package com.nttdata.hotelapp.service;

import com.nttdata.hotelapp.model.Payment;
import com.nttdata.hotelapp.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Mono<Payment> createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Mono<Payment> updatePayment(Long id, Payment payment) {
        return paymentRepository.findById(id)
                .flatMap(existingPayment -> {
                    existingPayment.setAmount(payment.getAmount());
                    existingPayment.setPaymentDate(payment.getPaymentDate());
                    existingPayment.setBookingId(payment.getBookingId());
                    return paymentRepository.save(existingPayment);
                });
    }

    public Mono<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Flux<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}