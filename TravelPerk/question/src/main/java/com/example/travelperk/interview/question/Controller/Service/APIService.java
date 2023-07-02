package com.example.travelperk.interview.question.Controller.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travelperk.interview.question.Client.APIClient;
import com.example.travelperk.interview.question.model.Model;

@Service
public class APIService {

    private APIClient client;

    @Autowired
    public APIService(APIClient client) {
        this.client = client;
    }

    public Model getAPIData() {
        return client.getAPIData();
    }
    
}
