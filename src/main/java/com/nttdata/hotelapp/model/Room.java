package com.nttdata.hotelapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("room")
public class Room {
    @Id
    private Long id;
    private String roomNumber;
    private String type;
    private Double price;
}