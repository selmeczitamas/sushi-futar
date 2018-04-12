package com.sushifutar.service;

import com.sushifutar.model.Food;
import com.sushifutar.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;


    public List<Food> findAll() {
        return foodRepository.findAll();
    }
    public Food findById(long id) { return foodRepository.findById(id);}
    public void saveFood(Food food) {
        foodRepository.save(food);
    }
}
