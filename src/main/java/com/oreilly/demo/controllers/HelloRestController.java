package com.oreilly.demo.controllers;

import com.oreilly.demo.entities.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Turn objects into JSON data (deserialization)
@RestController
public class HelloRestController {
    @GetMapping("/rest")
    // When "/rest" is used it will take an optional parameter for "name", which has a default value of "World"
    public Greeting greet(@RequestParam(required = false,
            defaultValue  = "World") String name) {
        // Returns a new Greeting object that receives a formatted string, which includes the parameter "name
        return new Greeting(String.format("Hello, %s!", name));
    }
}
