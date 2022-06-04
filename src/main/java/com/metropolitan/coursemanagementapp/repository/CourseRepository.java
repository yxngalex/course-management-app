package com.metropolitan.coursemanagementapp.repository;

import com.metropolitan.coursemanagementapp.entity.Course;
import com.metropolitan.coursemanagementapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
