package com.chato.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TetstController {

    @GetMapping("/t")
    private String test(){
        return "test";
    }

}
