package com.sushifutar.controller;

import com.sushifutar.model.Food;
import com.sushifutar.model.User;
import com.sushifutar.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private FoodService foodService;

    @ModelAttribute
    public void addAttributes(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Food> foods = foodService.findAll();
        model.addAttribute("foods", foods);
        return "index";
    }

    @RequestMapping("/bike/{id}/description")
    public String foodDetails(Model model, @PathVariable("id") Long id) {
        Food food = foodService.findById(id);
        System.out.println(food.toString());
        model.addAttribute("food", food);
        return "food-details";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}
