package vn.service;

import java.util.List;

public interface IService <T>{
    boolean create(T t);
    boolean update(T t);
    boolean deleteById(int id);
    T findById (int id);
    List<T> findAll();
}
