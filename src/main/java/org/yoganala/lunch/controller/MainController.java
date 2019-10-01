package org.yoganala.lunch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.yoganala.lunch.entity.User;
import org.yoganala.lunch.repository.UserRepo;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Controller
public class MainController {
    @Autowired
    private UserRepo userService;
    @RequestMapping("")
    public String index(){
        return "/static/index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
