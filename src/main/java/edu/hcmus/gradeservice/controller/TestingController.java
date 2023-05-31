package edu.hcmus.gradeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    @GetMapping("/api/v1/testing")
    public String testing() {
        return "testing....";
    }
}
