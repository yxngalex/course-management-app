package com.metropolitan.coursemanagementapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "USERNAME")
    private String username;

    @Lob
    @Column(name = "PASSWORD")
    private String password;

    @Lob
    @Column(name = "EMAIL")
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_fk", referencedColumnName = "role_id")
    @JsonIgnore
    private Role role = new Role();

}