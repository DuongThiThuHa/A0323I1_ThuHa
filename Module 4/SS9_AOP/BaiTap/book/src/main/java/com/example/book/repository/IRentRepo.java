package com.example.book.repository;

import com.example.book.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentRepo extends JpaRepository< Rent, String > {
}
