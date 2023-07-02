package com.example.travelperk.interview.question.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.travelperk.interview.question.Controller.Service.NearByPlacesService;
import com.example.travelperk.interview.question.model.Solution;

@RestController
@RequestMapping("/v3")
public class APIController {
    
    //private APIService service;

    private NearByPlacesService place;

    @Autowired
    public APIController(NearByPlacesService place) {
        //this.service = service;
        this.place = place;
    }

    /*@GetMapping("/apidata")
    public ResponseEntity<Model> GetAPIData() {
        return new ResponseEntity<>(service.getAPIData(), HttpStatus.OK);
    }

    @GetMapping("/apidata/{apiId}") 
    public ResponseEntity<Model> GetAPIDataWithPathVariable(@PathVariable String apiId) {
         HttpHeaders headers = new HttpHeaders();
         headers.add("apiId", apiId);
        return new ResponseEntity<>(service.getAPIData(), headers,HttpStatus.OK);
    }

    @GetMapping("/apidata1") 
    public ResponseEntity<Model> GetAPIDataWithRequestParam(@RequestParam(value = "apiId" , defaultValue = "default") String apiId) {
         HttpHeaders headers = new HttpHeaders();
         headers.add("apiId", apiId);
        return new ResponseEntity<>(service.getAPIData(), headers,HttpStatus.OK);
    }*/

    @GetMapping("/getplace")
    public ResponseEntity<String> GetPlaceData() {
        String lat = "41.399150";
        String Long = "2.193260";
        String input = "photo.jpg, Warsaw, 2013-09-05 14:08:15\nJay.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11";
        return new ResponseEntity<>(new Solution().solution(input), HttpStatus.OK);
    }
}
