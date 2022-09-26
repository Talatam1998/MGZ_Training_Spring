package com.mgz.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "instructor")
    private String instructor;

    @Column(name = "email")
    private String email;


    public Course(String courseName, String instructor, String email) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.email = email;
    }
}
