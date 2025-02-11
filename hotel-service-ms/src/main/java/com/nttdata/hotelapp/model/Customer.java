package com.nttdata.hotelapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("customer")
public class Customer {
    @Id
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String country;
}