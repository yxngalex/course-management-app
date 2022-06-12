package com.metropolitan.coursemanagementapp.service.impl;

import com.metropolitan.coursemanagementapp.entity.Course;
import com.metropolitan.coursemanagementapp.repository.CourseRepository;
import com.metropolitan.coursemanagementapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Integer courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("CourseService.notFound"));
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Integer courseId) {
        courseRepository.deleteById(courseId);
    }
}
