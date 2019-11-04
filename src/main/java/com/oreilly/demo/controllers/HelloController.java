package com.oreilly.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    // Defines the url for the http request
    @GetMapping("/hello")
    public String sayHello(
            // Takes in an request parameter called "name", if not included will use default string "World"
            @RequestParam(defaultValue = "World", required = false) String name,
            Model model) {
        // Adds the argument to the model
        model.addAttribute("user", name);
        // The returned string matches the html page in resources/templates
        return "hello";
    }
}
