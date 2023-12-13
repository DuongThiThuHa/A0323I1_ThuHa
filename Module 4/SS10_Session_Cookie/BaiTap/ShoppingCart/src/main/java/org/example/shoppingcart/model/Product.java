package org.example.shoppingcart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private int quantity;
    private int
}
