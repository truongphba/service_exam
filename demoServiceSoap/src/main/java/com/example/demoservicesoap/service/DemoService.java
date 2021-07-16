package com.example.demoservicesoap.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Component(value = "Demo")
@WebService
@Service
public class DemoService {
    @WebMethod
    public String demo() {
        return "demo";
    }
}
