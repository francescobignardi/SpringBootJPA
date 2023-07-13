package com.example.SpringBootJPA.AuthorsBooks.entity;

import com.example.SpringBootJPA.AuthorsBooks.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Authors")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer author_id;
    @Column(name = "name")
    private String name;
    @Column(name = "nationality")
    private String nationality;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Books books;
    @Column(name = "status", columnDefinition = "ACTIVE")
    private StatusEnum status;

    public Authors(String name, String nationality, Books books) {
        this.name = name;
        this.nationality = nationality;
        this.books = books;
    }

    public Authors(){}

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

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
