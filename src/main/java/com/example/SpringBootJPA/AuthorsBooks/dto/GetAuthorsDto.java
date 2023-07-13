package com.example.SpringBootJPA.AuthorsBooks.dto;

import com.example.SpringBootJPA.AuthorsBooks.entity.Books;

import java.util.List;

public class GetAuthorsDto {

    private Integer author_id;
    private String name;
    private String nationality;
    private List<Books> books;

    public GetAuthorsDto(String name, String nationality, List<Books> books) {
        this.name = name;
        this.nationality = nationality;
        this.books = books;
    }

    public GetAuthorsDto() {
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
