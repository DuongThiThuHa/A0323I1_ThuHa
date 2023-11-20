package com.example.demo_ss5.controller;

import com.example.demo_ss5.model.Product;
import com.example.demo_ss5.repository.CategoryRepo;
import com.example.demo_ss5.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
// yêu cầu HTTP nào đến đường dẫn /product đều sẽ được xử lý bởi phương thức.
public class ProductController {
    @Autowired
//  Tự động kết nối trên các thuộc tính, setters và hàm tạo.
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("product", productRepo.findAll());
        return "product/list";
    }

    @GetMapping("/craete")
    public String doCreate(@ModelAttribute("product") Product product){
        product.setCategory(categoryRepo.findById(product.getCategory().getCategoryID()));
        productRepo.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/detail/{id}")
    public String doUpdate(@RequestParam("id") int id, Model model){
        model.addAttribute("product",productRepo.deleteById(id));
        model.addAttribute(("category"),categoryRepo.findAll());
        return "product/update";
    }

    @GetMapping("/update")
    public String showUpdate(@ModelAttribute("product") Product product){
        product.setCategory(categoryRepo.findById(product.getCategory().getCategoryID()));
//        cập nhật danh mục của sản phẩm với danh mục tìm được từ cơ sở dữ liệu dựa trên ID danh mục hiện tại của sản phẩm.
        productRepo.update(product);
        return "redirect:/product/list";
//        Chuyen huong trang den muc product trang list
    }
}
