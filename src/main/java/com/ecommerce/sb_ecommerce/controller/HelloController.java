package com.ecommerce.sb_ecommerce.controller; // Defines the package where this controller resides.

import com.ecommerce.sb_ecommerce.response.HelloResponse; // Imports the response DTO
import org.springframework.web.bind.annotation.*;

// Marks this class as a REST controller in Spring Boot.
// It allows handling HTTP requests and returning responses.
@RestController
public class HelloController {

    // Handles HTTP GET requests to "/hello".
    // When accessed, it returns a JSON response containing "Hello World!".
    @GetMapping("/hello")
    public HelloResponse hello() {
        // Returns an instance of HelloResponse containing the message
        return new HelloResponse("Hello World");
    }

    // Handles HTTP POST requests to "/hello".
    // The request body (a string) is passed as an argument.
    // Returns a personalized greeting: "Hello <name>!"
    @PostMapping("/hello")
    public String helloPost(@RequestBody String name) {
        return "Hello " + name + "!";
    }
}
