package org.example.service;

import org.example.model.Book;
import org.example.model.Category;

import java.util.List;

public interface IService<T> {
    List< Book > findAll();
    boolean create(T t);
    boolean edit(T t);
    T findById(int id);
    boolean deleteById(int id);

}
