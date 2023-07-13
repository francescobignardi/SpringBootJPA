package com.example.SpringBootJPA.Esercizio5.exception;

import org.aspectj.weaver.ast.Not;

public class NotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NotFoundException (String message){
        super(message);
    }
}
