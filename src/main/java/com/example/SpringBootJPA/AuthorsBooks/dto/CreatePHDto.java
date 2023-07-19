package com.example.SpringBootJPA.AuthorsBooks.dto;

import com.example.SpringBootJPA.AuthorsBooks.entity.Authors;
import com.example.SpringBootJPA.AuthorsBooks.entity.Books;

import java.util.List;

public class CreatePHDto {
    private Integer publishingHouse_id;
    private String name;
    private String city;
    private List<Books> books;
    private List<Authors> authors;

    public CreatePHDto(String name, String city, List<Books> books, List<Authors> authors) {
        this.name = name;
        this.city = city;
        this.books = books;
        this.authors = authors;
    }
    public CreatePHDto(){}

    public Integer getPublishingHouse_id() {
        return publishingHouse_id;
    }

    public void setPublishingHouse_id(Integer publishingHouse_id) {
        this.publishingHouse_id = publishingHouse_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }
}
