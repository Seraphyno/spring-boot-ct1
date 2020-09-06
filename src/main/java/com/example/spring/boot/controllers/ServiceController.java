package com.example.spring.boot.controllers;

import com.example.spring.boot.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServiceController {

    // Autowire la nivel de proprietate - de folosit pt max 3 proprietati
    @Autowired
    private TestService service;

    // @Autowired folosit la nivel de constructor - mai usor de citit de la 3 proprietati in sus
//    @Autowired
//    public ServiceController(TestService service) {
//        this.service = service;
//    }

    @GetMapping("/test")
    public String testServiceInjection() {
        return service.testServiceInjection();
    }

    @GetMapping
    public String testApi() {
        return "in api, in ServiceController";
    }

    // Autowired merge si pe setter, pt fiecare proprietate de care am nevoie, va trebui sa creez un
    // setter separat, anotat
//    @Autowired
//    public void setService(TestService service) {
//        this.service = service;
//    }
}
