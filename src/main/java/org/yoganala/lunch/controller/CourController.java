package org.yoganala.lunch.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourController {
    @RequestMapping("/cour")
    public String test(){
        return "static/cour";
    }

    @RequestMapping("/createcour")
    @Secured(value = "ADMIN")
    public String test1(){
        return "admin/createcour";
    }

}
