package com.gbueno.app.controllers;

import com.gbueno.app.entities.TestLombok;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class Test {
    @GetMapping("/lombok")
    public String testLombok() {
        TestLombok test = new TestLombok();
        test.setMessage("Cheeto");
        test.setAge(25);

        return "Name: " + test.getMessage() + ", Age: " + test.getAge();
    }
}
