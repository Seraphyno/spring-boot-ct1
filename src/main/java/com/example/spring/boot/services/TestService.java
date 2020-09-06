package com.example.spring.boot.services;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String testServiceInjection() {
        return "Service was injected";
    }
}
