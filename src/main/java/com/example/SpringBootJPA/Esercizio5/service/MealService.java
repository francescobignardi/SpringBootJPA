package com.example.SpringBootJPA.Esercizio5.service;


import com.example.SpringBootJPA.Esercizio5.entity.Meal;
import com.example.SpringBootJPA.Esercizio5.repository.MealRepository;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {

    @Autowired
    public MealRepository mealRep;

    private final Double MAX_WINTER_TEMP = 12.0;

    public void insertMeal(Meal meal){
        mealRep.save(meal);
    }

    public Meal getMealById(Long id){
        return mealRep.findById(id).get();
    }

    public List<Meal> getAllMeals(){
        List<Meal> pasti = new ArrayList<Meal>();
        pasti.addAll(mealRep.findAll());
        return pasti;
    }

    public void deleteMeal(Long id){
        mealRep.deleteById(id);
    }

    public void updateMeal (Meal meal, Long id){
        mealRep.deleteById(id);
        mealRep.save(meal);
    }

    public void test(){
        mealRep.findByDescriptionAndPriceLessThan("Panino con salame e maionese", 5.5).forEach(System.out::println);
        System.out.println();
    }

    public List<Meal> getWinterMeals(){                               //video 11
        Double currentTemperature = getCurrentTemperature();
        if(currentTemperature <= MAX_WINTER_TEMP) return new ArrayList<>();
        return mealRep.findByIsWinterMeal(true);
    }

    private Double getCurrentTemperature(){
        try{
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=64.1355&longitude=-21.8954&hourly=temperature_2m")
                    .asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e){
            throw new RuntimeException(e);
        }
    }
}
