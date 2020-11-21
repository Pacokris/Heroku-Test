package com.example.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HomeController {

    private static final String HOME = "/home";

    @GetMapping("/")
    public ModelAndView displayHome(Map<String, Object> model) {
        String helloWorld = "HELLO WORLD !";
        model.put( "helloWorld", helloWorld );

        return new ModelAndView( HOME, model );
    }
}
