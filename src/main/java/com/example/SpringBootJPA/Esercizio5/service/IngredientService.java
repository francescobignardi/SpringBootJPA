package com.example.SpringBootJPA.Esercizio5.service;

import com.example.SpringBootJPA.Esercizio5.entity.Ingredient;
import com.example.SpringBootJPA.Esercizio5.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class IngredientService {

    @Autowired
    public IngredientRepository ingredientRep;

    public void insertIngredient(Ingredient ingredient){
        ingredientRep.save(ingredient);
    }


    public Ingredient getIngredientById(Long id){
        return ingredientRep.findById(id).get();
    }

    public List<Ingredient> getAllIngredients(){
        List<Ingredient> ingredienti = new ArrayList<Ingredient>();
        ingredienti.addAll(ingredientRep.findAll());
        return ingredienti;
    }

    public void deleteIngredient(Long id){
        ingredientRep.deleteById(id);
    }

    public void updateIngredient (Ingredient ingredient, Long id){
        ingredientRep.deleteById(id);
        ingredientRep.save(ingredient);
    }

}
