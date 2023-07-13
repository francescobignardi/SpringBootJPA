package com.example.SpringBootJPA.Esercizio5.controller;

import com.example.SpringBootJPA.Esercizio5.entity.Ingredient;
import com.example.SpringBootJPA.Esercizio5.entity.Meal;
import com.example.SpringBootJPA.Esercizio5.model.MealDto;
import com.example.SpringBootJPA.Esercizio5.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.SpringBootJPA.Esercizio5.model.MealDto;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {

    @Autowired
    public MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/insertMeal")
    public ResponseEntity<?> insertMeal(@RequestBody Meal meal){
        mealService.insertMeal(meal);
        return ResponseEntity.ok("Pasto inserito");
    }

    @GetMapping("/findById/{mealId}")
    public ResponseEntity<?> getMealById(@PathVariable("mealId") Long id){
        return ResponseEntity.ok(mealService.getMealById(id));
    }

    @GetMapping("/getAllMeals")
    public List<Meal> getAllMeals(){

        return mealService.getAllMeals();
    }

    @DeleteMapping("/deleteMeal/{mealId}")
    public ResponseEntity<?> deleteMeal(@PathVariable("mealId") Long id){
        mealService.deleteMeal(id);
        return ResponseEntity.ok("Pasto eliminato");
    }

    @PutMapping("/updateMeal/{mealId}")
    public ResponseEntity<?> updateMeal(@RequestBody Meal meal, @PathVariable("mealId") Long id){
        mealService.updateMeal(meal, id);
        return ResponseEntity.ok("Pasto modificato");
    }

    @PostMapping("/video9")
    public ResponseEntity<Meal> mealManyToOne(){
        Meal meal = new Meal("Tortelli di zucca", "Pasta all'uovo con ripieno di zucca", 9.0, true);
        Ingredient ingredient = new Ingredient("Zucca", true, true, true, true);

        ingredient.setMeal(meal);
        meal.setIngredients(Arrays.asList(ingredient));

        mealService.insertMeal(meal);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")                              //video 10
    public ResponseEntity<String> test(){
        mealService.test();
        return ResponseEntity.ok("test");
    }

    @GetMapping("winter-meals")
    public ResponseEntity<List<Meal>> getWinterMeals(){
        return ResponseEntity.ok(mealService.getWinterMeals());
    }

    @GetMapping("/get-by-id-dto")                         //dto Pasquale
    public MealDto getById(@RequestParam Long id){
        return mealService.getById(id);
    }

    @GetMapping("get-all-dto")
    public List<MealDto> getAll(){
        return mealService.getAll();
    }
}
