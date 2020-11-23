package com.example.helloworld.controller;

import com.example.helloworld.model.Users;
import com.example.helloworld.model.UsersContent;
import com.example.helloworld.service.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    private final HomeService homeService;
    private static final String HOME = "home";

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView displayHome(Map<String, Object> model) {

        String time = Instant.now().toString();
        model.put( "time", time );

        UsersContent usersContent = homeService.getAllUsers();
        model.put( "usersContent", usersContent );

        List<Users> users = homeService.getAllUsers().getUsers();
        model.put( "users", users );

        return new ModelAndView( HOME, model );
    }
}
