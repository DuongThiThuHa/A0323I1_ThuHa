package org.example.blog.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;
    @Column(name = "title")
    private String title;
    @Column(name = "content", length = 100000)
    private String content;
    @Column(name = "date")
    private Date publishDate;
    @ManyToOne
    @JoinColumn(name = "blogCategoryId")
    @JsonManagedReference
    private BlogCategory blogCategory;
}