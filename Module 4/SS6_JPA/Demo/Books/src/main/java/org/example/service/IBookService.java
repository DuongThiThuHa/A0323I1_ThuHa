package org.example.service;

import org.example.model.Book;

import java.util.List;

public interface IBookService extends IService< Book >{
    List<Book> findAllByName(String name);
}
