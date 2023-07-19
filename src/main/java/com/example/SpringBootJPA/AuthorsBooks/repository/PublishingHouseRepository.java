package com.example.SpringBootJPA.AuthorsBooks.repository;

import com.example.SpringBootJPA.AuthorsBooks.entity.PublishingHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, Integer> {
}
