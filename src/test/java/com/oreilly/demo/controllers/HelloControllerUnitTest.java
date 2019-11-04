package com.oreilly.demo.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HelloControllerUnitTest {

    @Test
    public void sayHello() {
        // Instantiates a new instance of the HelloController
        HelloController controller = new HelloController();
        // Creates a new model
        Model model = new BindingAwareModelMap();
        // Call the controller's sayHello method
        String result = controller.sayHello("World", model);

        //Check that the method returns the appropriate string
        assertEquals("hello", result);
        // Check that the value of "user" got put into the model as its default value
        assertEquals("World", model.asMap().get("user"));


    }
}
