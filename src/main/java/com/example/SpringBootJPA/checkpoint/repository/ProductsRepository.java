package com.example.SpringBootJPA.checkpoint.repository;

import com.example.SpringBootJPA.checkpoint.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
