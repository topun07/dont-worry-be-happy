package com.techelevator.auctions.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.auctions.model.CredentialsDto;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class AuthenticationService {

    private static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    public String login(String username, String password) {
        CredentialsDto credentialsDto = new CredentialsDto();
        credentialsDto.setUsername(username);
        credentialsDto.setPassword(password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CredentialsDto> entity = new HttpEntity<>(credentialsDto, headers);

        String token = null;
        try {
            // Send the POST request to the login endpoint
            // initially i was gett this and its because I asked for a string as opposed to JSON
            /*
            ResponseEntity<String> response = restTemplate.postForEntity(API_BASE_URL + "login", entity, String.class);

            // Extract the token from the response body
            if (response.getStatusCode() == HttpStatus.OK) {
                token = response.getBody();  // Assuming the token is returned as a string in the response body
            }*/
            // Send the POST request to the login endpoint
            ResponseEntity<String> response = restTemplate.postForEntity(API_BASE_URL + "login", entity, String.class);

            // Extract the token from the JSON response body
            if (response.getStatusCode() == HttpStatus.OK) {
                // Use ObjectMapper to parse the JSON response
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(response.getBody());
                token = ((JsonNode) jsonNode).get("token").asText();  // Extract the "token" field from the JSON
            }

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        catch (Exception e) {
        BasicLogger.log("Error parsing login response: " + e.getMessage());
    }

        return token;
    }

}
