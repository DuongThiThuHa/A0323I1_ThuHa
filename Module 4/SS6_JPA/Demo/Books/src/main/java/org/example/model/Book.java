package org.example.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "findBookByName", query = "from Book b where b.name like :name"),
        @NamedQuery(name = "findBookByCategoryName", query = "from Book b where b.category.categoryName like :categoryName")
})
public class Book {
    @Id
    private int id;
    private String name;
    private int quantity;
    private String author;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Book() {
    }

    public Book(int id, String name, int quantity, String author, Category category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.author = author;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
