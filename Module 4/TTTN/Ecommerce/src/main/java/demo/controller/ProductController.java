package demo.controller;

import demo.common.ApiResponse;
import demo.dto.ProductDto;
import demo.model.Category;
import demo.repository.CategoryRepo;
import demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("/add")
    public ResponseEntity< ApiResponse > createProduct(@RequestBody ProductDto productDto) {
        Optional< Category > optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity< ApiResponse >(new ApiResponse(false, "Category does not exists !"), HttpStatus.BAD_REQUEST);

        }
        productService.createProduct(productDto, optionalCategory.get());
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added !"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity< ApiResponse > updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) throws Exception {
        Optional< Category > optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity< ApiResponse >(new ApiResponse(false, "Category does not exists !"), HttpStatus.BAD_REQUEST);

        }
        productService.updateProduct(productDto, productId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated !"), HttpStatus.OK);
    }

}
