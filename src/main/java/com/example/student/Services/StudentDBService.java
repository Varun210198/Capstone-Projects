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
    public void removeStudent(Long studentId) throws StudentNotFoundException{
        if(studentRepository.existsById(studentId)){
            studentRepository.deleteById(studentId);
        }
        else{
            throw new StudentNotFoundException("Student with Id : "+studentId+" not present!.");
        }
    }

//    @Override
//    public Student replaceStudent(StudentRequestDto requestDto, Long id) {
//        return null;
//    }

    @Override
    public Student createOrReplaceStudent(Student updatedStudent, Long studentId) {
        //1)check if student exists
        //2)Update the new Student with the existing Student's Id
        //3)Save the new Student in place of existing Student
        //Note - since we are passing new id - save() will update the existing student
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(!studentOptional.isEmpty()){
            //Optional.get() will throw error when optional it is empty
            Student existingStudent = studentOptional.get();
            updatedStudent.setId(existingStudent.getId());
            return studentRepository.save(updatedStudent);
        }
        else {
            //this dont have id in it so save() should create the student
            //Save() returns the Student object directly not the optional
            return studentRepository.save(updatedStudent);
        }
    }

    @Override
    public Student updateStudent(Student updatedStudent,Long studentId) throws StudentNotFoundException {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isEmpty()){
            throw new StudentNotFoundException("Student with id : "+studentId+" does not exist");
        }
        Student existingStudent = studentOptional.get();
        //Update only not null fields from new student

        if (updatedStudent.getName() != null){
            existingStudent.setName(updatedStudent.getName());
        }
        if (updatedStudent.getAge() != null){
            existingStudent.setAge(updatedStudent.getAge());
        }
        if (updatedStudent.getCourse() != null){
            existingStudent.setCourse(updatedStudent.getCourse());
        }
        if (updatedStudent.getDOB() != null){
            existingStudent.setDOB(updatedStudent.getDOB());
        }

        return  studentRepository.save(existingStudent);

    }

    ;

//For Entire replacement

//    return studentRepository.findById(id).map(existingStudent -> {
//        // Completely replace the existing student
//        updatedStudent.setId(existingStudent.getId());  // Preserve the existing ID
//        return studentRepository.save(updatedStudent);  // Save the new object as a whole
//    }).orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
}
