package com.example.SpringBootJPA.AuthorsBooks.service;

import com.example.SpringBootJPA.AuthorsBooks.repository.BooksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private ModelMapper modelMapper;
}
