package com.example.customer.service;

import com.example.customer.model.Product;
import com.example.customer.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepo iProductRepo;

//    Phuong thuc cua create va update la khai bao giong nhau
    @Override
    public boolean create(Product product) {
        iProductRepo.save(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        iProductRepo.save(product);
        return true;
    }


//    Nếu Product tồn tại, phương thức orElse(null) sẽ trả về đối tượng Product đó.
//    Nếu không, nó sẽ trả về null, biểu thị rằng không có sản phẩm nào có ID tương ứng trong cơ sở dữ liệu.
    @Override
    public Product findById(int id) {
        return iProductRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepo.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        iProductRepo.deleteById(id);
        return true;
    }
}
