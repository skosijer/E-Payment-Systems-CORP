package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/corpMain")
public class MainController {

    @Value("${datacentar.url}")
    private String datacentarUrl;

    @RequestMapping(value = "/dobaviStarosneGrupe", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRegions(){
        RestTemplate rt =  new RestTemplate();
        ResponseEntity<String> ret = rt.getForEntity("http://" + this.datacentarUrl + "/dcRizici/dobaviStarosneGrupe", String.class);
        return ret;
    }
}
