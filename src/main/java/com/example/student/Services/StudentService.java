package com.example.student.Services;

import com.example.student.Dtos.StudentRequestDto;
import com.example.student.Dtos.StudentResponseDto;
import com.example.student.Exceptions.StudentNotFoundException;
import com.example.student.Models.Student;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface StudentService {

    //Fetches Student by Id
    public Student getStudentById(Long studentId) throws StudentNotFoundException;

    //Creates new Student
    public Student createStudent(StudentRequestDto requestDto);

    //Fetches All Students
    public List<Student> getAllStudents();

    //Deletes Student with mentioned Id and
    //returns message like " Student ID is Deleted Successfully!!!"
    public String removeStudent(Long id) throws StudentNotFoundException;
}
