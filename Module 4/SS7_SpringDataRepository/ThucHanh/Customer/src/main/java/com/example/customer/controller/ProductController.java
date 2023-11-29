package com.example.customer.controller;

import com.example.customer.model.Category;
import com.example.customer.model.Product;
import com.example.customer.repository.ICategoryRepo;
import com.example.customer.repository.IProductRepo;
import com.example.customer.service.CategoryService;
import com.example.customer.service.ICategoryService;
import com.example.customer.service.IProductService;
import com.example.customer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductRepo iProductRepo;
     @Autowired
    private ICategoryRepo iCategoryRepo ;


//     Hien thi danh sach
     @GetMapping("/list")
    public String showList(Model model){
         model.addAttribute("products",iProductRepo.findAll());
         return "product/list";
     }

//     Tim kiem theo ten
    @GetMapping("/search")
    public String showSearch(Model model, @RequestParam("product_name") String name){
         model.addAttribute("product",iProductRepo.findAllByName(name));
         return "product/list";
    }

//Them moi san pham
@GetMapping("/create")
    public String showCreate(Model model){
         model.addAttribute("product", new Product());
         model.addAttribute("category", new Category());
         return "product/create";
}

// tìm kiếm một sản phẩm với ID tương ứng trong DB và hiển thị chi tiết sản phẩm đó
@GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id){
         Optional<Product> product = iProductRepo.findById(id);
         model.addAttribute("product",product);
         return "product/detail";
}

//Hien thi chuc nang cap nhap
@GetMapping("update")
    public String showUpdate(@RequestParam("id") int id, Model model){
         model.addAttribute("product" , iProductRepo.findById(id));
         model.addAttribute("category" , iCategoryRepo.findAll());
         return "product/update";
}

//Thuc hien chuc nang dang nhap
@PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product){
//         product.setCategory(iCategoryRepo.findById(product.getCategory().getCategoryId()));
         iProductRepo.update("product");
         return "redirect:/product/list";

}
}
