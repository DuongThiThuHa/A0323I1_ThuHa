package com.example.book.service;

import com.example.book.model.Book;

import java.util.List;

public interface IBookService {
    List< Book > findAll();
    Book findById(int id);
    void rent(Book book);
}
