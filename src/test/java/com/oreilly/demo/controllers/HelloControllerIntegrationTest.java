package com.oreilly.demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
// A mock MVC object using the HelloController class
// Not a real server
@WebMvcTest(HelloController.class)
public class HelloControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testHelloWithoutName() throws Exception {
        // Uses the mcv object & makes a get request to the controller, with no parameters
        mvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
                // Should return a 200
                .andExpect(status().isOk())
                // Returns the correct view (thymeleaf template)
                .andExpect(view().name("hello"))
                // Model should have an attribute called "user", which is the default value of "World"
                .andExpect(model().attribute("user", is("World")));

    }

    @Test
    public void testHelloWithName() throws Exception {
        // Makes a get request and passes in a parameter ("name" = "Dolly")
        mvc.perform(get("/hello").param("name", "Dolly").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                // Model should have an attribute called "user", which is set "Dolly"
                .andExpect(model().attribute("user", is("Dolly")));

    }
}
