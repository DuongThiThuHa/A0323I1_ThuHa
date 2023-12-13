package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepo iBookRepo;
    @Override
    public List< Book > findAll() {
        return iBookRepo.findAll();
    }

    @Override
    public Book findById(int id) {
        return iBookRepo.findById(id).orElse(null);
    }

    @Override
    public void rent(Book book) {
        iBookRepo.save(book);
    }
}
