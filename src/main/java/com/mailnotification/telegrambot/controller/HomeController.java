package com.mailnotification.telegrambot.controller;

import com.mailnotification.telegrambot.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping(value = "/configuration", method = RequestMethod.GET)
    public String configuration() {
         return "configuration";
    }

    @RequestMapping(value ={"/login"} , method = RequestMethod.GET)
    public String login() {
          return "login";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = {"/home","/"}, method = RequestMethod.GET)
    public String home() {
       return "home";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model) {
        String message = "Ups, sorry. Access Denied!";
        model.addAttribute("message", message);
        return "403Page";
    }

}
