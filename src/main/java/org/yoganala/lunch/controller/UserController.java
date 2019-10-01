package org.yoganala.lunch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yoganala.lunch.entity.User;
import org.yoganala.lunch.repository.UserRepo;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;
    @RequestMapping("/user")
    public String test(){
        return "static/user";
    }
}
