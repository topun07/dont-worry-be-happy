package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatPic;

@Component
public class RestCatPicService implements CatPicService {

	private static final String API_URL = "https://teapi.netlify.app/api/cats/pictures/random";
	private RestTemplate restTemplate = new RestTemplate();

    public CatPic getPic() throws RestClientResponseException {
    	CatPic catPic = restTemplate.getForObject(API_URL, CatPic.class);
        return catPic;
    }

}
