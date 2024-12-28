package com.example.limits_service.controller;


import com.example.limits_service.bean.Limits;
import com.example.limits_service.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {


    @Autowired
    private Configuration configuration;


    @GetMapping("/limits")
    public Limits retrieveLimits(){

        return new Limits(configuration.getMinimum(), configuration.getMaximum());
//        return new Limits(1,2000);

    }



}
