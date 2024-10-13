package com.example.student.controlleradvice;

import com.example.student.Dtos.ErrorDto;
import com.example.student.Exceptions.StudentNotFoundException;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
//    @ExceptionHandler(StudentNotFoundException.class)
//    public ErrorDto handleStudentNotFoundException(){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage("Student Not Found!");
//        errorDto.setStatus("FAILURE");
//        return errorDto;
//    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorDto> handleStudentNotFoundException(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setStatus("FAILURE");
        errorDto.setMessage("Student Not Found!");
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

}
