package com.metropolitan.coursemanagementapp.repository;

import com.metropolitan.coursemanagementapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
