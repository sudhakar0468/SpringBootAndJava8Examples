package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {


    @GetMapping(value = "/v1/testAPI")
    public String getTestResponse() {
        return "Test Response in API";
    }

}
