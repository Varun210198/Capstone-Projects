package com.example.student.Services;

import com.example.student.Dtos.StudentRequestDto;
import com.example.student.Exceptions.StudentNotFoundException;
import com.example.student.Models.Student;
import com.example.student.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentDBService implements StudentService{
    StudentRepository studentRepository;

    public StudentDBService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentById(Long studentId) throws StudentNotFoundException{
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isEmpty()){
            throw new StudentNotFoundException("Student "+studentId+" not found!!");
        }
        return studentOptional.get();
    }

    @Override
    public Student createStudent(StudentRequestDto requestDto) {
        return studentRepository.save(StudentRequestDto.toStudent(requestDto));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public String removeStudent(Long studentId) throws StudentNotFoundException{
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional == null){
            throw new StudentNotFoundException("Student with Id : "+studentId+" not present!.");
        }
        studentRepository.delete(studentOptional.get());
        return "Student with Id :"+studentId+" is deleted successfully!.";
    }
}
