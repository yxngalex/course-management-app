package com.metropolitan.coursemanagementapp.service.impl;

import com.metropolitan.coursemanagementapp.entity.Role;
import com.metropolitan.coursemanagementapp.repository.RoleRepository;
import com.metropolitan.coursemanagementapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Integer roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new NoSuchElementException("RoleService.notFound"));
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(Integer roleId) {
        roleRepository.deleteById(roleId);
    }
}
