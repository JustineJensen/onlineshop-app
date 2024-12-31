package com.example.storeproject.configs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resources")
public class LoginController {
  /*  @GetMapping("public")
    public ResponseEntity<String>publicEndpoint(){
       return new ResponseEntity<> (
               "Any one can access it.", HttpStatus.OK);
    }*/
}
