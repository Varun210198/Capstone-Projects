package com.example.student.Dtos;

import com.example.student.Models.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentRequestDto {
    //In Request we dont need ID but in response we need
    String name;
    Integer age;
    String course;
    Date dob;

    public static Student toStudent(StudentRequestDto requestDto){
        //Converts the given DTo to Student Objects and returns Student object
        return new Student(requestDto.getName(), requestDto.getAge(), requestDto.getCourse(),requestDto.getDob());
    }
}

