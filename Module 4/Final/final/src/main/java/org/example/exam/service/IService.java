package org.example.exam.service;

import java.util.List;

public interface IService <T>{
    boolean create(T t);
    boolean deleteById(int id);
    T findById (int id);
    List<T> findAll();
}
