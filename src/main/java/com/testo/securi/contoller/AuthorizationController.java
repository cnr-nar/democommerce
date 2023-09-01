package com.testo.securi.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resource")
public class AuthorizationController {
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Here is your resource");
    }
}
