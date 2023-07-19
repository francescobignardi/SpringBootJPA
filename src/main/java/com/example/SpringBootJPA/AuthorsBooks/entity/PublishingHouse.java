package com.example.SpringBootJPA.AuthorsBooks.entity;

import com.example.SpringBootJPA.AuthorsBooks.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PublishingHouse")
public class PublishingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publishingHouse_id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Books books;
    @ManyToMany
    @JoinTable(name = "Registered_authors",
    joinColumns = @JoinColumn(name = "author_id"),
    inverseJoinColumns = @JoinColumn(name = "publishingHouse_id"))
    @JsonBackReference
    private List<Authors> authors;

    public PublishingHouse(String name, String city, Books books) {
        this.name = name;
        this.city = city;
        this.books = books;
    }
    public PublishingHouse(){}

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

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }
}
