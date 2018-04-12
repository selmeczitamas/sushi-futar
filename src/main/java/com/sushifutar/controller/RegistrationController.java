package com.sushifutar.controller;

import com.sushifutar.model.User;
import com.sushifutar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/regisztracio", method = RequestMethod.GET)
    public String register(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/regisztracio", method = RequestMethod.POST)
    public String register(@RequestParam HashMap<String, String> params, Model model, HttpSession session){
        User user = userService.createUser(params);
        userService.saveUser(user);
        session.setAttribute("user", user);
        model.addAttribute("user",user);
        return "redirect:/";
    }
}
