package com.example.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String author;

    @Min(0)
    private int quantity;
    @OneToMany(mappedBy = "rent")
    private List<Rent> rentList;

    public Book() {
    }

    public Book(int id, String name, String author, int quantity, List< Rent > rentList) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.rentList = rentList;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List< Rent > getRentList() {
        return rentList;
    }

    public void setRentList(List< Rent > rentList) {
        this.rentList = rentList;
    }
}
