package com.cleverdeveloper.petclinicapp.controllers;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/21/2021 10:12 PM
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("/oups")
    public String errorHandler() {
        return "notfound";
    }
}
