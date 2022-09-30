package com.mgz.controller;

import com.mgz.model.Course;
import com.mgz.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.NoSuchElementException;



@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    @RolesAllowed({"ROLE_ADMIN","ROLE_USER"})

    public List<Course> list(){
       return courseService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    @RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
    public ResponseEntity<Course> get(@PathVariable Integer id){
        try{
            Course course = courseService.getCourseById(id);
            return  new ResponseEntity<Course>(course,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return  new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/course")
    @RolesAllowed({"ROLE_ADMIN"})
    public void add(@RequestBody Course course){
            courseService.saveCourse(course);
    }

    @PutMapping("/course/{id}")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<?> update(@RequestBody Course course, @PathVariable Integer id){
        try {
            Course existCourse = courseService.getCourseById(id);
            courseService.saveCourse(course);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/course/{id}")
    @RolesAllowed({"ROLE_ADMIN"})
    public void  delete(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }
}
