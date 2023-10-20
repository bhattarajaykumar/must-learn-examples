package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MyFirstRestController {

    @GetMapping("/greetAll")
    public String sayHello() {
        return "Hello All";
    }

    @GetMapping("/greetUser/{userName}")
    public String sayHello(@PathVariable("userName") String userName) {
        return "Hello "+userName;
    }

}
