package com.example.demo.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/corp-insurance-forms")
public class MainController {

    @RequestMapping(value = "/regions/getAll", method = RequestMethod.GET)
    public String getAllRegions(){
//        RestTemplate rt =  new RestTemplate();
//        rt.getForEntity("http://localhost:8082/dc-insurance-forms/regions/getAll", String.class);
        return "NRs";
    }
}
