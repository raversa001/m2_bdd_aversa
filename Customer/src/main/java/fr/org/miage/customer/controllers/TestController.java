package fr.org.miage.customer.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${a}")
    private int a;

    @GetMapping("/test")
    public String getConfig() {
        return "a = " + a;
    }
}
