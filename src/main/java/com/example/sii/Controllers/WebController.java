package com.example.sii.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping("/")
    public String getHelloWorld()
    {
        return "Hello World!";
    }
}
