package com.example.SpringBootJPA.AuthorsBooks.entity;

import com.example.SpringBootJPA.AuthorsBooks.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
    @Column(name = "title")
    private String title;
    @Column(name = "publication_year")
    private Integer publication_year;
    @OneToMany(mappedBy = "books")
    private List<Authors> author;
    @OneToMany(mappedBy = "books")
    @JsonManagedReference
    private List<PublishingHouse> publishingHouseList;
    @Column(name = "status", columnDefinition = "ACTIVE")
    private StatusEnum status;


    public Books(String title, Integer publication_year, List<Authors> author, List<PublishingHouse> publishingHouseList) {
        this.title = title;
        this.publication_year = publication_year;
        this.author = author;
        this.publishingHouseList = publishingHouseList;
    }

    public Books(){}

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Integer publication_year) {
        this.publication_year = publication_year;
    }

    public List<Authors> getAuthor() {
        return author;
    }

    public void setAuthor(List<Authors> author) {
        this.author = author;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public List<PublishingHouse> getPublishingHouseList() {
        return publishingHouseList;
    }

    public void setPublishingHouseList(List<PublishingHouse> publishingHouseList) {
        this.publishingHouseList = publishingHouseList;
    }
}
