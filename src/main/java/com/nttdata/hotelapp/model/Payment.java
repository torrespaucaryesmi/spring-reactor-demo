package com.nttdata.hotelapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("payment")
public class Payment {
    @Id
    private Long id;
    private Long bookingId;
    private Double amount;
    private LocalDateTime paymentDate;
}