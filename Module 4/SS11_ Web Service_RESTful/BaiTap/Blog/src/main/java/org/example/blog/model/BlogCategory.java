package org.example.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "caregory")
public class BlogCategory {
    @Id
    @Column(name = "categoryId")
    private int blogCategoryId;
    @Column(name = "categoryName")
    private String categoryName;
    @OneToMany
    @JsonBackReference
    private List<Blog> blogList;
}
