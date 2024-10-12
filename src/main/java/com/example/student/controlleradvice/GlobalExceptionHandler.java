package com.example.student.controlleradvice;

import com.example.student.Dtos.ErrorDto;
import com.example.student.Exceptions.StudentNotFoundException;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ErrorDto handleNullPointerException(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Student Not Found!");
        errorDto.setStatus("FAILURE");
        return errorDto;
    }

}
