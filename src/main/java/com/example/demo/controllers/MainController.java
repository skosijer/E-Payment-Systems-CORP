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
    
    @RequestMapping(value = "/dobaviRegione", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviDestinacije(){
        RestTemplate rt =  new RestTemplate();
        ResponseEntity<String> ret = rt.getForEntity("http://" + this.datacentarUrl + "/dcRizici/dobaviRegione", String.class);
        return ret;
    }
    
    @RequestMapping(value = "/dobaviSvrheOsiguranja", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviSvrheOsiguranja(){
        RestTemplate rt =  new RestTemplate();
        ResponseEntity<String> ret = rt.getForEntity("http://" + this.datacentarUrl + "/dcRizici/dobaviSvrheOsiguranja", String.class);
        return ret;
    }
    
    @RequestMapping(value = "/dobaviPaketeOsiguranja", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviPaketeOsiguranja(){
        RestTemplate rt =  new RestTemplate();
        ResponseEntity<String> ret = rt.getForEntity("http://" + this.datacentarUrl + "/dcRizici/dobaviPaketeOsiguranja", String.class);
        return ret;
    }
    
    @RequestMapping(value = "/dobaviStarostiStana", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviStarostiStana(){
        RestTemplate rt =  new RestTemplate();
        ResponseEntity<String> ret = rt.getForEntity("http://" + this.datacentarUrl + "/dcRizici/dobaviStarostiStana", String.class);
        return ret;
    }
    
    @RequestMapping(value = "/dobaviProcenjeneVrednostiStana", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviProcenjeneVrednostiStana(){
        RestTemplate rt =  new RestTemplate();
        ResponseEntity<String> ret = rt.getForEntity("http://" + this.datacentarUrl + "/dcRizici/dobaviProcenjeneVrednostiStana", String.class);
        return ret;
    }
    
    @RequestMapping(value = "/dobaviOsiguranjaStana", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviOsiguranjaStana(){
        RestTemplate rt =  new RestTemplate();
        ResponseEntity<String> ret = rt.getForEntity("http://" + this.datacentarUrl + "/dcRizici/dobaviOsiguranjaStana", String.class);
        return ret;
    }
}
