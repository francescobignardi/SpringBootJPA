package com.example.SpringBootJPA.Esercizio5.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;
    private boolean isWinterMeal;                               // per esercizio sull'external API

    public Meal(String name, String description, Double price, Boolean isWinterMeal) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isWinterMeal = isWinterMeal;
    }

    public Meal(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isWinterMeal() {
        return isWinterMeal;
    }

    public void setWinterMeal(boolean winterMeal) {
        isWinterMeal = winterMeal;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                '}';
    }
}

