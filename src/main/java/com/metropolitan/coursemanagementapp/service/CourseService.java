package com.metropolitan.coursemanagementapp.service;

import com.metropolitan.coursemanagementapp.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(Integer courseId);

    Course saveCourse(Course course);

    Course updateCourse(Course course);

    void deleteById(Integer courseId);
}
