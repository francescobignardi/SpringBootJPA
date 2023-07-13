package com.example.SpringBootJPA.AuthorsBooks.controller;

import com.example.SpringBootJPA.AuthorsBooks.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {
    private BooksService booksService;
    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
}
