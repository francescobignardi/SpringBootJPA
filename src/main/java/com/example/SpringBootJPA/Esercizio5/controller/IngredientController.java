package com.example.SpringBootJPA.Esercizio5.controller;

import com.example.SpringBootJPA.Esercizio5.entity.Ingredient;
import com.example.SpringBootJPA.Esercizio5.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    public IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/insertIngredient")
    public ResponseEntity<?> insertIngredient(@RequestBody Ingredient ingredient){
        ingredientService.insertIngredient(ingredient);
        return ResponseEntity.ok("Ingrediente inserito");
    }

    @GetMapping("/findById/{ingredientId}")
    public ResponseEntity<?> getIngredientById(@PathVariable("ingredientId") Long id){
        return ResponseEntity.ok(ingredientService.getIngredientById(id));
    }

    @GetMapping("/getAllIngredients")
    public List<Ingredient> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }

    @DeleteMapping("/deleteIngredient/{ingredientId}")
    public ResponseEntity<?> deleteIngredient(@PathVariable("ingredientId") Long id){
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok("Ingrediente eliminato");
    }

    @PutMapping("/updateIngredient/{ingredientId}")
    public ResponseEntity<?> updateIngredient(@RequestBody Ingredient ingredient, @PathVariable("ingredientId") Long id){
        ingredientService.updateIngredient(ingredient, id);
        return ResponseEntity.ok("Ingrediente modificato");
    }
}
