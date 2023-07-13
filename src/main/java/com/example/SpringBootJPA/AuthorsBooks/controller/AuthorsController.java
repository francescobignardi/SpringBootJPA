package com.example.SpringBootJPA.AuthorsBooks.controller;

import com.example.SpringBootJPA.AuthorsBooks.dto.CreateAuthorsDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.GetAuthorsDto;
import com.example.SpringBootJPA.AuthorsBooks.entity.Authors;
import com.example.SpringBootJPA.AuthorsBooks.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private AuthorsService authorsService;
    @Autowired
    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("/getAllAuthors")
    public List<GetAuthorsDto> getAllAuthors(){
        return authorsService.getAllAuthors();
    }

    @PostMapping("insertAuthor")
    public CreateAuthorsDto insertAuthor(@RequestBody CreateAuthorsDto newAuthor){
        CreateAuthorsDto author = authorsService.createAuthorsDto(newAuthor);
        return newAuthor;
    }

    @GetMapping("/findAuthorById")
    public GetAuthorsDto getAuthorById(@RequestParam Integer id){
        return authorsService.getAuthorById(id);
    }

    @PutMapping("/updateAuthorById")
    public CreateAuthorsDto updateAuthor(@RequestParam Integer id, @RequestBody CreateAuthorsDto createAuthorsDto){
        return authorsService.updateAuthor(id, createAuthorsDto);
    }

    @DeleteMapping("/deleteAuthorById")
    public GetAuthorsDto deleteAuthor(@RequestParam Integer id){
        return authorsService.deleteAuthor(id);
    }

}
