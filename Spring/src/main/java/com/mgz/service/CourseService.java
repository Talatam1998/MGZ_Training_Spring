package com.mgz.service;

import com.mgz.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface CourseService {
    List<Course> getAllCourses();
    void saveCourse(Course course);
    Course getCourseById(long id);
    void deleteCourse(long id);
    Page<Course> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
