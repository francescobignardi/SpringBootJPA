package com.example.SpringBootJPA.AuthorsBooks.repository;

import com.example.SpringBootJPA.AuthorsBooks.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer> {
}
