package com.example.student.Repositories;

import com.example.student.Models.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student save(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();



}
