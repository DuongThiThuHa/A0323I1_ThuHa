package org.example.demo.repository;

import org.example.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompanyRepo extends JpaRepository< Company, Integer > {
    List< Company > findAllByNameContaining(String name);
    @Query("From Company c where c.name like :name")
    public List< Company > search(@Param("name") String name);
}
