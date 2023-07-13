package com.example.SpringBootJPA.AuthorsBooks.repository;

import com.example.SpringBootJPA.AuthorsBooks.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
}
