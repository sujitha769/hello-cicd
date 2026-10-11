package com.suji.hellocicd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for the hello endpoint.
 */
@RestController
public class HelloController {

    /**
     * Returns a greeting message.
     *
     * @return greeting message
     */
    @GetMapping("/hello")
    public String hello() {

                               return "Hello, CI/CD Pipeeline7";
    }
}