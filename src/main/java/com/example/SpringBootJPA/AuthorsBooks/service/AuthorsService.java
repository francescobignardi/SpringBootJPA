package com.example.SpringBootJPA.AuthorsBooks.service;

import com.example.SpringBootJPA.AuthorsBooks.dto.CreateAuthorsDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.GetAuthorsDto;
import com.example.SpringBootJPA.AuthorsBooks.entity.Authors;
import com.example.SpringBootJPA.AuthorsBooks.enums.StatusEnum;
import com.example.SpringBootJPA.AuthorsBooks.repository.AuthorsRepository;
import com.example.SpringBootJPA.Esercizio5.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AuthorsService {

    @Autowired
    private AuthorsRepository authorsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<GetAuthorsDto> getAllAuthors(){
        return authorsRepository.findAll().stream()
                .map(authors -> modelMapper.map(authors, GetAuthorsDto.class))
                .collect(Collectors.toList());
    }

    public CreateAuthorsDto createAuthorsDto (CreateAuthorsDto createAuthorsDto){
        Authors author = modelMapper.map(createAuthorsDto, Authors.class);
        Authors savedAuthor = authorsRepository.save(author);
        return modelMapper.map(savedAuthor, CreateAuthorsDto.class);
    }

    public GetAuthorsDto getAuthorById(Integer id){
        Optional<Authors> author = authorsRepository.findById(id);
        if(author.isPresent()){
            return modelMapper.map(author.get(), GetAuthorsDto.class);
        }
        throw new NotFoundException("Autore non trovato" + id);
    }

    public CreateAuthorsDto updateAuthor(Integer id, CreateAuthorsDto createAuthorsDto){
        Optional<Authors> author = authorsRepository.findById(id);
        if(author.isPresent()){
            Authors authorR = author.get();
            authorR.setName(createAuthorsDto.getName());
            authorR.setNationality(createAuthorsDto.getNationality());
            Authors updatedAuthor = authorsRepository.save(authorR);
            return modelMapper.map(updatedAuthor, CreateAuthorsDto.class);
        }
        throw new NotFoundException("Autore non trovato" + id);
    }

    public GetAuthorsDto deleteAuthor(Integer id){
        Optional<Authors> author = authorsRepository.findById(id);
        if(author.isPresent()){
            Authors authorR = author.get();
            authorR.setStatus(StatusEnum.DELETED);
            authorsRepository.save(authorR);
        }
        throw new NotFoundException("Autore non trovato" + id);
    }
}
