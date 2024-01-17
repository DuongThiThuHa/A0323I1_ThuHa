package vn.service;

import vn.model.Blog;
import vn.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo iBlogRepo;

    @Override
    public List< Blog > findAllByName(String name) {
        return iBlogRepo.findAllByNameContaining(name);
    }

    @Override
    public boolean create(Blog book) {
        iBlogRepo.save(book);
        return true;
    }

    @Override
    public boolean update(Blog book) {
        iBlogRepo.save(book);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        iBlogRepo.deleteById(id);
        return true;
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepo.findById(id).orElse(null);
    }

    @Override
    public List< Blog > findAll() {
        return iBlogRepo.findAll();
    }
}
