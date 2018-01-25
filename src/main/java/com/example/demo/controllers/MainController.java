package com.example.demo.controllers;


import com.example.demo.DTO.PolisaDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/corpMain")
public class MainController {

    @Value("${datacentar.url}")
    private String datacentarUrl;
    
    @Value("${error.origin.name}")
	private String errorOriginName; 

    @Autowired
    private RestTemplate rt;

    private final Log logger = LogFactory.getLog(this.getClass());

    @PostMapping(value = "/polisa")
    public ResponseEntity<?> postPolisa(@RequestBody PolisaDTO polisa) {
        ResponseEntity<?> response = rt.postForEntity("https://" + this.datacentarUrl + "/dcRizici/polisa", polisa, String.class);
        return response;
    }
    
    @RequestMapping(value = "/dobaviStarosneGrupe", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviStarosneGrupe(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/dobaviStarosneGrupe", String.class);
        return ret;
    }

    @RequestMapping(value = "/getOsiguranjaDoIznosa", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviOsiguranjaDoIznosa(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/getOsiguranjaDoIznosa", String.class);
        return ret;
    }

    @RequestMapping(value = "/dobaviRegione", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviDestinacije(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/dobaviRegione", String.class);
        return ret;
    }
    
    @RequestMapping(value = "/dobaviSvrheOsiguranja", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviSvrheOsiguranja(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/dobaviSvrheOsiguranja", String.class);
        return ret;
    }
    
    @RequestMapping(value = "/dobaviPaketeOsiguranja", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviPaketeOsiguranja(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/dobaviPaketeOsiguranja", String.class);
        return ret;
    }
    
    @RequestMapping(value = "/dobaviStarostiStana", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviStarostiStana(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/dobaviStarostiStana", String.class);
        return ret;
    }
    
    @RequestMapping(value = "/dobaviProcenjeneVrednostiStana", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviProcenjeneVrednostiStana(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/dobaviProcenjeneVrednostiStana", String.class);
        return ret;
    }
    
    @RequestMapping(value = "/dobaviOsiguranjaStana", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviOsiguranjaStana(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/dobaviOsiguranjaStana", String.class);
        return ret;
    }

    @RequestMapping(value = "/getSlepovanje", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviSlepovanje(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/getSlepovanje", String.class);
        return ret;
    }

    @RequestMapping(value = "/getPopravka", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviPopravka(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/getPopravka", String.class);
        return ret;
    }

    @RequestMapping(value = "/getSmestaj", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviSmestaj(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/getSmestaj", String.class);
        return ret;
    }

    @RequestMapping(value = "/getPrevoz", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviPrevoz(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/getPrevoz", String.class);
        return ret;
    }

    @RequestMapping(value = "/getPovrsina", method = RequestMethod.GET)
    public ResponseEntity<?> dobaviPovrsinu(){
        ResponseEntity<String> ret = rt.getForEntity("https://" + this.datacentarUrl + "/dcRizici/getPovrsina", String.class);
        return ret;
    }
    
    @ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<?> exceptionHandlerHttpError(HttpClientErrorException ex) {
		String body = ex.getResponseBodyAsString();
		RestClientExceptionInfo info = new RestClientExceptionInfo(); 
		
		
		if(RestClientExceptionInfo.parse(body) == null) {
			//ova aplikacija je uzrok exceptiona
			//priprema se exception za propagiranje dalje i loguje se
			info.setOrigin(errorOriginName);
			info.setInfo(body);
		}
		else {
			info.setOrigin(RestClientExceptionInfo.parse(body).getOrigin() );
			info.setInfo(RestClientExceptionInfo.parse(body).getInfo() );
		}
		logger.error("HttpClientErrorException, info:" + RestClientExceptionInfo.toJSON(info));
		
		
		return ResponseEntity.status(ex.getStatusCode()).body(RestClientExceptionInfo.toJSON(info));
	}
}
