package com.example.hateoas.controller;

import com.example.hateoas.properties.ApiList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    ApiList apiList;

    @RequestMapping("/")
    public ApiList getAllApi() {
        return apiList;
    }

}