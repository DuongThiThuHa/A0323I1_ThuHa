package com.example.demo_ss5.repository;

import java.util.List;

public interface Repository<T> {
//    <T> : Tham chiếu đến một đối tượng "T kí hiệu kiểu Type"(Generic)
    boolean create(T t);
    boolean update(T t);
    T findById(int id);
    List<T> findAll();
    boolean deleteById(int id);
}
