package com.example.travelperk.interview.question.Controller.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travelperk.interview.question.Client.APIClient;
import com.example.travelperk.interview.question.model.FourSquare;

@Service
public class NearByPlacesService {

    private APIClient client;

    @Autowired
    public NearByPlacesService(APIClient client) {
        this.client = client;
    }

    public List<String> findNearbyPlaces(String lat, String longitude) {
       FourSquare result = client.getPlacesInfo(lat, longitude);
        return Arrays.asList(result.getResults()).stream().map(place->place.getName()).collect(Collectors.toList());
    }
}
