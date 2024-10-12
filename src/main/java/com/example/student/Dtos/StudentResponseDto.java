package com.example.student.Dtos;

import com.example.student.Models.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class StudentResponseDto {
    //In response, we need I'd but in request we dont need
    private Long id;
    private String name;
    private Integer age;
    private String course;
    private Date DOB;
    public static StudentResponseDto fromStudent(Student student){
        StudentResponseDto responseDto = new StudentResponseDto();
        responseDto.setId(student.getId());
        responseDto.setAge(student.getAge());
        responseDto.setName(student.getName());
        responseDto.setCourse(student.getCourse());
        responseDto.setDOB(student.getDOB());

        return responseDto;
    }
}
