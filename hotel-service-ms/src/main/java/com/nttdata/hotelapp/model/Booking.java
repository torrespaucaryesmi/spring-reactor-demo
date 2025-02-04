package com.nttdata.hotelapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("booking")
public class Booking {
    @Id
    private Long id;
    private Long customerId;
    private Long roomId;
    private LocalDateTime bookingDate;
}