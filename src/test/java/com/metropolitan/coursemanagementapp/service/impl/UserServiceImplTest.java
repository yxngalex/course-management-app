package com.metropolitan.coursemanagementapp.service.impl;

import com.metropolitan.coursemanagementapp.entity.Role;
import com.metropolitan.coursemanagementapp.entity.User;
import com.metropolitan.coursemanagementapp.repository.UserRepository;
import com.metropolitan.coursemanagementapp.service.RoleService;
import com.metropolitan.coursemanagementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    @Test
    void getAllUsersTest() {
        List<User> userList = userService.getAllUsers();
        when(userRepository.findAll()).thenReturn(userList);
        Integer expectedCount = userList.size();
        assertEquals(expectedCount, userRepository.findAll().size());
    }

    @Test
    void saveUserTest() {
        User user = new User();
        Role role = new Role();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        role.setName("ROLE_TEST");
        user.setUsername("Test");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");
        user.setRole(role);

        when(userRepository.save(user)).thenReturn(user);
        System.out.println(user);
        assertEquals(user, userService.saveUser(user));
    }

    @Test
    void updateUserTest() {
        User user = new User();
        Role role = new Role();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        role.setName("ROLE_TEST");
        user.setUsername("Updated Test");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");
        user.setRole(role);
        when(userRepository.save(user)).thenReturn(user);

        User actualUser = userService.saveUser(user);
        System.out.println(user);
        assertEquals(user, actualUser);
        assertEquals(user.getUsername(), actualUser.getUsername());
        assertEquals(user.getPassword(), actualUser.getPassword());
        assertEquals(user.getRole().getName(), actualUser.getRole().getName());
    }

    @Test
    void getUserByUsernameTest() {
        String userName = "stefan";

        User user = new User();
        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_ADMIN");
        user.setId(13);
        user.setUsername("stefan");
        user.setPassword("$2a$12$LP/ahNreRJ9lGKENYmHvwu2CdHrSGEI1v2i5E49kddvuSWnQCvxTy");
        user.setEmail("stefan@gmail.com");
        user.setRole(role);

        when(userRepository.findByUsername(userName)).thenReturn(user);

        User actualUser = userRepository.findByUsername(userName);


        assertEquals(user, actualUser);
        assertEquals(userName, actualUser.getUsername());
    }

    @Test
    void getUserByEmailTest() {
        String email = "user@gmail.com";

        User user = new User();
        Role role = roleService.getRoleById(3);
        user.setId(15);
        user.setUsername("user");
        user.setPassword("$2a$12$rfybhogfgRtBqj/63WKsIezoUwHY1a1iWIS5.QDm8k6CbRM1bCSwC");
        user.setEmail("user@gmail.com");
        user.setRole(role);

        when(userRepository.findByEmail(email)).thenReturn(user);

        User actualUser = userRepository.findByEmail(email);

        assertEquals(user, actualUser);
        assertEquals(email, actualUser.getEmail());
    }

    @Test
    void getUserByIdTest() {
        Integer id = 14;
        User user = new User();
        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_ADMIN");
        user.setId(14);
        user.setUsername("aleksa");
        user.setPassword("$2a$12$ZdZ046FRbwOr4cv86vUteOf8e0HOZK2MSWVNdIXaf8thgPz4YWgF2");
        user.setEmail("aleksa@gmail.com");
        user.setRole(role);

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        User actualUser = userService.getUserById(id);
        assertEquals(user, actualUser);
        assertEquals(id, actualUser.getId());
    }

    @Test
    void deleteByIdTest() {
        userService.deleteById(15);
        verify(userRepository, times(1)).deleteById(15);
    }
}