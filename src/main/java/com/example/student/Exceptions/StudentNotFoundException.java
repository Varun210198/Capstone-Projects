package com.example.student.Exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String message){
        super(message);
    }
}
