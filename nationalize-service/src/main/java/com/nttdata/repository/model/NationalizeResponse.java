package com.nttdata.repository.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NationalizeResponse {
    private String name;
    private List<CountryProbability> country;

    @Data
    public static class CountryProbability {
        @JsonProperty("country_id")
        private String countryId;
        private double probability;
        private int count;
    }
}