package org.example.service;

import org.example.model.Customer;

import java.util.List;

public interface Service<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);

}
