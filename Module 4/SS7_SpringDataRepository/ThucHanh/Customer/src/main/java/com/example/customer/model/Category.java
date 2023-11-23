package com.example.customer.model;

import jdk.dynalink.linker.LinkerServices;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name", columnDefinition = "varchar(100)")
//    Xac dinh ten cot va so luong phan tu trong DB
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
    public Category() {
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
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
}
