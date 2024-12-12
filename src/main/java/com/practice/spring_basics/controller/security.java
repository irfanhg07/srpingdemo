package com.practice.spring_basics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class security {

    @GetMapping()
    public String demo(){

        return "<h1> This is demo of spring security</h1>";

    }

    @GetMapping("/one")
    public String demoOne(){

        return "<h1> This is demo of spring security ONE</h1>";

    }

    @GetMapping("/two")
    public String demoTwo(){

        return "<h1> This is demo of spring security TWO</h1>";

    }

    @GetMapping("/three")
    public String demoThree(){

        return "<h1> This is demo of spring security THREE</h1>";

    }
}
