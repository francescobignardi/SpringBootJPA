package com.example.SpringBootJPA.Esercizio5.repository;

import com.example.SpringBootJPA.Esercizio5.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findByDescription(String description);
    List<Meal> findByPriceLessThan(Double price);
    List<Meal> findByPriceBetween(Double x, Double y);
    List<Meal> findByDescriptionAndPriceLessThan(String description, Double price);

    List<Meal> findByIsWinterMeal(boolean isWinterMeal);   //video 11
}
