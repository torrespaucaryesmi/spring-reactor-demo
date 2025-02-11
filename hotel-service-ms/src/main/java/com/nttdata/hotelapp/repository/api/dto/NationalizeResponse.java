package com.nttdata.hotelapp.repository.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NationalizeResponse {

    private String code;
    private BigDecimal percentage;
}
