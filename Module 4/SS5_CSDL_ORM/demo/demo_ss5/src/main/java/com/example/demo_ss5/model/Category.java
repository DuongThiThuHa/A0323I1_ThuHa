package com.example.demo_ss5.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category {
    @Id //Đánh dấu là primary key
    @GeneratedValue // Giúp tự động tăng
    private int categoryID;

    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public Category() {
    }

    public Category(int categoryID, String categoryName, List<Product> productList) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.productList = productList;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
