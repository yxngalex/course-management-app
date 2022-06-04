package com.metropolitan.coursemanagementapp.repository;

import com.metropolitan.coursemanagementapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
