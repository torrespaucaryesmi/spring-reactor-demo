package com.nttdata.service.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class NationalDTO {

    private String code;
    private BigDecimal percentage;

}
