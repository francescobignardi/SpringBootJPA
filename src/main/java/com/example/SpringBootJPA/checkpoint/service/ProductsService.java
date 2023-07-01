package com.example.SpringBootJPA.checkpoint.service;

import com.example.SpringBootJPA.checkpoint.entity.Products;
import com.example.SpringBootJPA.checkpoint.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {
    @Autowired
    public ProductsRepository productsRepository;

    public void insertProduct(Products product){
        productsRepository.save(product);
    }

    public Products getProductById(Integer id){
        return productsRepository.findById(id).get();
    }

    public List<Products> getAllProducts(){
        List<Products> prodotti = new ArrayList<Products>();
        prodotti.addAll(productsRepository.findAll());
        return prodotti;
    }

    public void deleteProducts(Integer id){
        productsRepository.deleteById(id);
    }

    public void updateProduct (Products product, Integer id){
        productsRepository.deleteById(id);
        productsRepository.save(product);
    }
}
