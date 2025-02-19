package com.ecommerce.sb_ecommerce.controller; // Defines the package where this controller resides.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Marks this class as a REST controller in Spring Boot.
// This means it can handle HTTP requests and return responses.
@RestController
public class HelloController {

    // Handles HTTP GET requests to "/hello".
    // When accessed, it returns the string "Hello World!" as a response.
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    // Handles HTTP POST requests to "/hello".
    // The request body (a string) is passed as an argument.
    // Returns a personalized greeting: "Hello <name>!"
    @PostMapping("/hello")
    public String helloPost(@RequestBody String name) {
        return "Hello " + name + "!";
    }
}
