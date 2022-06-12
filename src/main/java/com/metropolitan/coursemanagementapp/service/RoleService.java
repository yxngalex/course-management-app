package com.metropolitan.coursemanagementapp.service;

import com.metropolitan.coursemanagementapp.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleById(Integer roleId);

    Role saveRole(Role role);

    Role updateRole(Role role);

    void deleteById(Integer roleId);
}
