package org.example.exam.repository;

import org.example.exam.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository< Category ,Integer> {
}
