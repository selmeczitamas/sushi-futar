package com.sushifutar.controller;

import com.sushifutar.model.Food;
import com.sushifutar.model.User;
import com.sushifutar.service.FoodService;
import com.sushifutar.service.PasswordEncoder;
import com.sushifutar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class LoginController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private FoodService foodService;

    @Autowired
    public LoginController(UserService userService, PasswordEncoder passwordEncoder, FoodService foodService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.foodService = foodService;
    }

    @ModelAttribute
    public void addAttributes(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLoginPage(Model model) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(Model model, @RequestParam HashMap<String, String> loginDetails, HttpSession session) {

        String userEmail = loginDetails.get("email");
        System.out.println("User email: " + userEmail);
        User dbUser = userService.getUserByEmail(userEmail);
        System.out.println("User: " + dbUser);
        Boolean loginSuccess = false;

        if (dbUser != null) {
            String userPassword = loginDetails.get("password");
            String encodedPassword = dbUser.getPassword();
            if (passwordEncoder.getbCryptPasswordEncoder().matches(userPassword, encodedPassword)) {
                loginSuccess = true;
                session.setAttribute("user", dbUser);
                model.addAttribute("user", dbUser);
                model.addAttribute("loginSuccess", loginSuccess);
                return "redirect:/";
            }
        }
        List<Food> foods = foodService.findAll();
        model.addAttribute("foods", foods);
        model.addAttribute("loginSuccess", loginSuccess);
        return "loginError";
    }
}
