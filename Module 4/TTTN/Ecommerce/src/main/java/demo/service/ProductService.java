package demo.service;

import demo.dto.ProductDto;
import demo.exceptions.ProductNotExistsException;
import demo.model.Category;
import demo.model.Product;
import demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setImageUrl(product.getImageUrl());
        product.setName(product.getName());
        product.setCategory(category);
        product.setPrice(product.getPrice());
        productRepo.save(product);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getId());
        return productDto;
    }

    public List< ProductDto > getAllProducts() {
        List< Product > allProducts = productRepo.findAll();

        List< ProductDto > productDtos = new ArrayList<>();
        for (Product product : allProducts) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
        Optional< Product > optionalProduct = productRepo.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new Exception("Product not present !");
        }
        Product product = optionalProduct.get();
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
    }

    public Product findById(Integer productId) throws ProductNotExistsException {
        Optional< Product > optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotExistsException("Product id id not valid" + productId);
        }
        return optionalProduct.get();
    }


}
