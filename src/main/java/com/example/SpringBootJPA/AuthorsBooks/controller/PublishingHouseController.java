package com.example.SpringBootJPA.AuthorsBooks.controller;

import com.example.SpringBootJPA.AuthorsBooks.dto.CreatePHDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.GetAuthorsDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.GetPHDto;
import com.example.SpringBootJPA.AuthorsBooks.entity.PublishingHouse;
import com.example.SpringBootJPA.AuthorsBooks.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishingHouse")
public class PublishingHouseController {
    private PublishingHouseService publishingHouseService;
    @Autowired
    public PublishingHouseController(PublishingHouseService publishingHouseService) {
        this.publishingHouseService = publishingHouseService;
    }
    @GetMapping("/getAllPublishingHouses")
    public List<GetPHDto> getAllPublishingHouses(){
        return publishingHouseService.getAllPublishingHouses();
    }
    @PostMapping("/insertPublishingHouse")
    public CreatePHDto insertPublishingHouse(@RequestBody CreatePHDto newPublishingHouse) {
        CreatePHDto publishingHouse = publishingHouseService.createPublishingHouseDto(newPublishingHouse);
        return newPublishingHouse;
    }
    @GetMapping("/findPublishingHouseById")
    public GetPHDto getPublishingHouseById(@RequestParam Integer id){
        return publishingHouseService.getPublishingHouseById(id);
    }
    @PutMapping("/updatePublishingHouseById")
    public CreatePHDto updatePublishingHouse(@RequestParam Integer id, @RequestBody CreatePHDto createPHDto){
        return publishingHouseService.updatePublishingHouse(id, createPHDto);
    }
    @DeleteMapping("/deletePublishingHouseById")
    public void deletePublishingHouse(@RequestParam Integer id){
        publishingHouseService.DeletePublishingHouse(id);
    }
}
