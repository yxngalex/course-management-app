package com.metropolitan.coursemanagementapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "CATEGORY_TYPE")
    private String categoryType;

    @Lob
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
}