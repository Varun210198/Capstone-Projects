package com.example.student.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class Student extends BaseModel{
     private String name;
     private Integer age;
     private String course;
     private Date DOB;
}
