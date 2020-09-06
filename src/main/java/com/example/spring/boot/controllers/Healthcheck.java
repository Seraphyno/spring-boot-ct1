package com.example.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
// este putin mai specific decat @Component, dar dintre controllere, este tot generic
// adica pt functionalitati custom trebuie sa mai fac niste configuratii
// ex: trebuie sa folosesc @ResponseBody langa @GetMapping
@RestController
// este o implementare specifica de controller, nu este nevoie sa mai folosesc @ResponseBody
public class Healthcheck {

    @GetMapping("/health")
//    @ResponseBody
    public String getHealth() {
        return "Up and running!";
    }
}
