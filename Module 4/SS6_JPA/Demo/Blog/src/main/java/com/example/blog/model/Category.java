package com.example.blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private int categoryId;

    private String name;

    @OneToMany(mappedBy = "category")
    List<Blog> blogs;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Category(int categoryId, String name, List<Blog> blogs) {
        this.categoryId = categoryId;
        this.name = name;
        this.blogs = blogs;
    }

    public Category() {
    }
}