package vn.repository;

import vn.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository< Category, Integer > {
}
