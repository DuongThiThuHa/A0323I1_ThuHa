package org.example.service;

import org.example.model.Book;
import org.example.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepo iBookRepo;
    @Override
    public List< Book > findAllByName(String name) {
        iBookRepo.findAllByNameContaining(name);
        return null;
    }

    @Override
    public List< Book > findAll() {
        return iBookRepo.findAll();
    }

    @Override
    public boolean create(Book book) {
         iBookRepo.save(book);
         return true;
    }

    @Override
    public boolean edit(Book book) {
        iBookRepo.save(book);
        return true;
    }

    @Override
    public Book findById(int id) {
        return iBookRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {iBookRepo.deleteById(id);
        return true;
    }
}
