package com.example.SpringBootJPA.AuthorsBooks.controller;

import com.example.SpringBootJPA.AuthorsBooks.dto.CreateAuthorsDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.CreateBooksDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.GetAuthorsDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.GetBooksDto;
import com.example.SpringBootJPA.AuthorsBooks.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private BooksService booksService;
    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
    @GetMapping("/getAllBooks")
    public List<GetBooksDto> getAllBooks(){
        return booksService.getAllBooks();
    }
    @PostMapping("/insertBook")
    public CreateBooksDto insertBook(@RequestBody CreateBooksDto newBook){
        CreateBooksDto book = booksService.createBooksDto(newBook);
        return newBook;
    }
    @GetMapping("/findBookById")
    public GetBooksDto getBookById(@RequestParam Integer id){
        return booksService.getBookById(id);
    }

    @PutMapping("/updateBookById")
    public CreateBooksDto updateBook(@RequestParam Integer id, @RequestBody CreateBooksDto createBooksDto){
        return booksService.updateBook(id, createBooksDto);
    }

    @DeleteMapping("/deleteBookById")
    public GetBooksDto deleteBook(@RequestParam Integer id){
        return booksService.deleteBook(id);
    }

}
