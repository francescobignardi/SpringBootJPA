package com.example.SpringBootJPA.AuthorsBooks.service;


import com.example.SpringBootJPA.AuthorsBooks.dto.CreateAuthorsDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.CreatePHDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.GetAuthorsDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.GetPHDto;
import com.example.SpringBootJPA.AuthorsBooks.entity.Authors;
import com.example.SpringBootJPA.AuthorsBooks.entity.Books;
import com.example.SpringBootJPA.AuthorsBooks.entity.PublishingHouse;
import com.example.SpringBootJPA.AuthorsBooks.enums.StatusEnum;
import com.example.SpringBootJPA.AuthorsBooks.repository.AuthorsRepository;
import com.example.SpringBootJPA.AuthorsBooks.repository.BooksRepository;
import com.example.SpringBootJPA.AuthorsBooks.repository.PublishingHouseRepository;
import com.example.SpringBootJPA.Esercizio5.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublishingHouseService {
    @Autowired
    private PublishingHouseRepository publishingHouseRepository;
    @Autowired
    private AuthorsRepository authorsRepository;
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<GetPHDto> getAllPublishingHouses(){
        return publishingHouseRepository.findAll().stream()
                .map(publishingHouses -> modelMapper.map(publishingHouses, GetPHDto.class))
                .collect(Collectors.toList());
    }

    public CreatePHDto createPublishingHouseDto (CreatePHDto createPHDto){
        PublishingHouse publishingHouse = modelMapper.map(createPHDto, PublishingHouse.class);
        PublishingHouse savedPublishingHouse = publishingHouseRepository.save(publishingHouse);
        return modelMapper.map(savedPublishingHouse, CreatePHDto.class);
    }

    public GetPHDto getPublishingHouseById(Integer id){
        Optional<PublishingHouse> publishingHouse = publishingHouseRepository.findById(id);
        if(publishingHouse.isPresent()){
            return modelMapper.map(publishingHouse.get(), GetPHDto.class);
        }
        throw new NotFoundException("Casa editrice non trovata" + id);
    }

    public CreatePHDto updatePublishingHouse(Integer id, CreatePHDto createPHDto){
        Optional<PublishingHouse> publishingHouse = publishingHouseRepository.findById(id);
        if(publishingHouse.isPresent()){
            PublishingHouse publishingHouseE = publishingHouse.get();
            publishingHouseE.setName(createPHDto.getName());
            publishingHouseE.setCity(createPHDto.getCity());
            PublishingHouse updatedPublishingHouse = publishingHouseRepository.save(publishingHouseE);
            return modelMapper.map(updatedPublishingHouse, CreatePHDto.class);
        }
        throw new NotFoundException("Casa editrice non trovata" + id);
    }

    /**public GetPHDto deletePublishingHouse(Integer id){
        Optional<PublishingHouse> publishingHouse = publishingHouseRepository.findById(id);
        if(publishingHouse.isPresent()){
            PublishingHouse publishingHouseE = publishingHouse.get();
            publishingHouseE.setStatus(StatusEnum.DELETED);
            publishingHouseRepository.save(publishingHouseE);
        }
        throw new NotFoundException("Casa editrice non trovata" + id);
    }
     */

    public void DeletePublishingHouse(Integer id){
        publishingHouseRepository.deleteById(id);
    }
}
