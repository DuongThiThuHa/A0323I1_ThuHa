package com.example.blog.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
//NamedQueries: định nghĩa nhiều truy vấn
//NamedQuery: định nghĩa một truy vấn
@NamedQueries({
        @NamedQuery( name= "findBlogByName", query = "from Blog blog where blog.name like :name"),
        @NamedQuery(name = "findCategoryByName", query = "from Category cate where cate.categoryName like :categoryName")
})
public class Blog {
    @Id
    private int id;
    private String name;
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRelease;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String name, String author, Date dateRelease, Category category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.dateRelease = dateRelease;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
