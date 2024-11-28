package com.google.Oauth2.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController

public class MainController {

    @RequestMapping("/")
     public String home() {
        return "Welcome";
    }
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    @GetMapping("/profile")
    public String profile(OAuth2AuthenticationToken token) {
        String name=token.getPrincipal().getAttribute("name");
        String email=token.getPrincipal().getAttribute("email");
        System.out.println(name);
        System.out.println(email);
        return "success";
    }
}
