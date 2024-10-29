package com.techelevator.locations.services;

import com.techelevator.locations.models.TaxDto;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TaxService {

    public static final String API_BASE_URL = "https://teapi.netlify.app/api";
    private RestTemplate restTemplate = new RestTemplate();

    public BigDecimal getTaxRate(String stateCode) {
        String url = API_BASE_URL + "/statetax?state=" + stateCode.toUpperCase();
        TaxDto taxResponseDto = restTemplate.getForObject(url, TaxDto.class);
        return taxResponseDto.getSalesTax();
    }

}
