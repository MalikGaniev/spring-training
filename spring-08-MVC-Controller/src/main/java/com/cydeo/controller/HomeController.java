package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

@RequestMapping("/home")
    public String home(){ //which en point?www.amazon.com/register
        return "home.html";
    }
    @RequestMapping("/malik")
    public String getHomePage2(){ //which en point?www.amazon.com/register
        return "home.html";
    }
    @RequestMapping// nothing and /
    public String getHomePage3(){ //which en point?www.amazon.com/register
        return "home.html";
    }
    @RequestMapping({"/apple","/orange"})
    public String getHomePage4(){ //which en point?www.amazon.com/register
        return "home.html";
    }

}
