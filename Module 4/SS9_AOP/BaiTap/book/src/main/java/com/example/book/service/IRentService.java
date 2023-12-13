package com.example.book.service;

import com.example.book.model.Rent;

import java.util.List;

public interface IRentService {
    void create(Rent rent);
    Rent findById(String id);
    List<Rent> findAll();
    void delete(Rent rent);
}
