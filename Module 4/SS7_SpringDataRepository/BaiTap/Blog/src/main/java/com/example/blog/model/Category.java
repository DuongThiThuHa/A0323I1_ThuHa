package com.example.blog.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "categoryName", columnDefinition = "varchar(100)")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    List<Blog> blogList;

    public Category() {
    }

    public Category(int categoryId, String categoryName, List< Blog > blogList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.blogList = blogList;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List< Blog > getBlogList() {
        return blogList;
    }

    public void setBlogList(List< Blog > blogList) {
        this.blogList = blogList;
    }
}
