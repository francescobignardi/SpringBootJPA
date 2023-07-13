package com.example.SpringBootJPA.Esercizio5.service;


import com.example.SpringBootJPA.Esercizio5.entity.Meal;
import com.example.SpringBootJPA.Esercizio5.model.MealDto;
import com.example.SpringBootJPA.Esercizio5.repository.MealRepository;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    public MealRepository mealRep;

    private Double MAX_WINTER_TEMP = 12.0;

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
        if(currentTemperature > MAX_WINTER_TEMP) return new ArrayList<>();  //è come un if else
        return mealRep.findByIsWinterMeal(true);
    }

    private Double getCurrentTemperature(){
        try{
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=-35.2835&longitude=149.1281&current_weather=true")
                    .asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e){
            throw new RuntimeException(e);
        }
    }

    public MealDto getById(Long id){                   //dto Pasquale
        Optional<Meal> mMeal= mealRep.findById(id);
        if(mMeal.isPresent()){
            Meal m = mMeal.get();
            MealDto dto = new MealDto();
            dto.setName(m.getName());
            dto.setDescription(m.getDescription());
            dto.setPrice(m.getPrice());
            return dto;
        } else {
            throw new RuntimeException("Errore");
        }
    }

    public List<MealDto> getAll(){                    //mia prova per getAll con dto
        List<Meal> meals = mealRep.findAll();
        List<MealDto> mealsDto = new ArrayList<>();

        for(Meal m : meals){
            MealDto mealDto = new MealDto();
            mealDto.setName(m.getName());
            mealDto.setDescription(m.getDescription());
            mealDto.setPrice(m.getPrice());
            mealsDto.add(mealDto);
        }
        return mealsDto;
    }
}
