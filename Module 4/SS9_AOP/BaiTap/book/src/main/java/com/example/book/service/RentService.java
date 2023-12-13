package com.example.book.service;

import com.example.book.model.Rent;
import com.example.book.repository.IRentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentService implements IRentService{
    @Autowired
    private IRentRepo iRentRepo;
    @Override
    public void create(Rent rent) {
        iRentRepo.save(rent);
    }

    @Override
    public Rent findById(String id) {
        return iRentRepo.findById(id).orElse(null);
    }

    @Override
    public List< Rent > findAll() {
        return iRentRepo.findAll();
    }

    @Override
    public void delete(Rent rent) {
        iRentRepo.delete(rent);
    }
}
