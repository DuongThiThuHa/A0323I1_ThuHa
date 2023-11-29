package org.example.repository;

import org.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookRepo extends JpaRepository< Book, Integer > {
    public List<Book> findAllByNameContaining(String name);

    @Query("from books b where b.name like :name")
    public List<Book> search(@Param("name") String name);
}
