package com.example.travelperk.interview.question.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.travelperk.interview.question.model.FourSquare;
import com.example.travelperk.interview.question.model.Model;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class APIClient {
    @Value("${external.api}")
    private String externalApi;

    @Value("${places.api}")
    private String placeApi;

    @Value("${api.key}")
    private String key;

    private ObjectMapper mapper;
    
    @Autowired
    public APIClient(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public Model getAPIData() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(externalApi, String.class);
        String responseBody = response.getBody();
        Model responseModel = null;

        try {
            // Parse the response into Java objects
            responseModel = mapper.readValue(responseBody, Model.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseModel;
    }

    public FourSquare getPlacesInfo(String lat, String longitude) {
        String url = prepareUrl(lat, longitude);
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", key);
        HttpEntity<Object> entity=new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        String responseBody = response.getBody();
        FourSquare result = null;
        try {
            // Parse the response into Java objects
            result = mapper.readValue(responseBody, FourSquare.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String prepareUrl(String lat, String longitude) {
        String queryParam = lat+","+longitude;
        return String.format(placeApi, queryParam);
    }
}
