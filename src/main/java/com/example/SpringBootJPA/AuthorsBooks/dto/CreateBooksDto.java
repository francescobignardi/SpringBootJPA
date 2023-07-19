package com.example.SpringBootJPA.AuthorsBooks.dto;

import com.example.SpringBootJPA.AuthorsBooks.entity.Authors;
import com.example.SpringBootJPA.AuthorsBooks.entity.PublishingHouse;

import java.util.List;

public class CreateBooksDto {
    private Integer book_id;
    private String title;
    private Integer publication_year;
    private List<Authors> author;
    private List<PublishingHouse> publishingHouseList;

    public CreateBooksDto(String title, Integer publication_year, List<Authors> author, List<PublishingHouse> publishingHouseList) {
        this.title = title;
        this.publication_year = publication_year;
        this.author = author;
        this.publishingHouseList = publishingHouseList;
    }
    public CreateBooksDto(){}

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

    public List<PublishingHouse> getPublishingHouseList() {
        return publishingHouseList;
    }

    public void setPublishingHouseList(List<PublishingHouse> publishingHouseList) {
        this.publishingHouseList = publishingHouseList;
    }
}
