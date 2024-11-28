package com.google.Oauth2.service;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class GoogleApiService {

    private final String GOOGLE_API_URL = "https://www.googleapis.com/oauth2/v3/userinfo";

    public Map<String, Object> fetchGoogleUserInfo(String accessToken) {
        String url = GOOGLE_API_URL;

        // Build the request with the OAuth2 token
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        // Make the GET request to the Google API
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, new HttpEntity<>(headers), Map.class
        );

        return response.getBody(); // Return the user profile details from Google API
    }
}

