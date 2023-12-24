package org.example.cart.repository;

import org.example.cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductRepo extends JpaRepository< Product, Integer > {
}
