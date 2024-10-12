package com.example.student.Controller;

import com.example.student.Dtos.StudentRequestDto;
import com.example.student.Dtos.StudentResponseDto;
import com.example.student.Exceptions.StudentNotFoundException;
import com.example.student.Models.Student;
import com.example.student.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    StudentService studentService ;
    public StudentController(StudentService studentService){
        this.studentService = studentService;

    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable("id") Long id) throws StudentNotFoundException {
        Student student = studentService.getStudentById(id);
        StudentResponseDto responseDto =  StudentResponseDto.fromStudent(student);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/student")
    public List<StudentResponseDto> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        List<StudentResponseDto> responseDtos = new ArrayList<>();
        for(Student student : students){
            responseDtos.add(StudentResponseDto.fromStudent(student));
        }
        return responseDtos;
    }

    @PostMapping("/student")
    public StudentResponseDto createStudent(@RequestBody StudentRequestDto requestDto){
        Student student = studentService.createStudent(requestDto);
        return StudentResponseDto.fromStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable("id") long id)throws StudentNotFoundException{
        return  studentService.removeStudent(id);
    }

}
