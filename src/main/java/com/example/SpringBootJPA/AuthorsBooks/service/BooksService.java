package com.example.SpringBootJPA.AuthorsBooks.service;

import com.example.SpringBootJPA.AuthorsBooks.dto.CreateAuthorsDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.CreateBooksDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.GetAuthorsDto;
import com.example.SpringBootJPA.AuthorsBooks.dto.GetBooksDto;
import com.example.SpringBootJPA.AuthorsBooks.entity.Authors;
import com.example.SpringBootJPA.AuthorsBooks.entity.Books;
import com.example.SpringBootJPA.AuthorsBooks.enums.StatusEnum;
import com.example.SpringBootJPA.AuthorsBooks.repository.BooksRepository;
import com.example.SpringBootJPA.Esercizio5.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<GetBooksDto> getAllBooks(){
        return booksRepository.findAll().stream()
                .map(books -> modelMapper.map(books, GetBooksDto.class))
                .collect(Collectors.toList());
    }
    public CreateBooksDto createBooksDto (CreateBooksDto createBooksDto){
        Books books = modelMapper.map(createBooksDto, Books.class);
        Books savedBook = booksRepository.save(books);
        return modelMapper.map(savedBook, CreateBooksDto.class);
    }
    public GetBooksDto getBookById(Integer id){
        Optional<Books> book = booksRepository.findById(id);
        if(book.isPresent()){
            return modelMapper.map(book.get(), GetBooksDto.class);
        }
        throw new NotFoundException("Libro non trovato" + id);
    }

    public CreateBooksDto updateBook(Integer id, CreateBooksDto createBooksDto){
        Optional<Books> book = booksRepository.findById(id);
        if(book.isPresent()){
            Books bookK = book.get();
            bookK.setTitle(createBooksDto.getTitle());
            bookK.setPublication_year(createBooksDto.getPublication_year());
            Books updatedBook = booksRepository.save(bookK);
            return modelMapper.map(updatedBook, CreateBooksDto.class);
        }
        throw new NotFoundException("Libro non trovato" + id);
    }

    public GetBooksDto deleteBook(Integer id){
        Optional<Books> book = booksRepository.findById(id);
        if(book.isPresent()){
            Books bookK = book.get();
            bookK.setStatus(StatusEnum.DELETED);
            booksRepository.save(bookK);
        }
        throw new NotFoundException("Libro non trovato" + id);
    }
}
