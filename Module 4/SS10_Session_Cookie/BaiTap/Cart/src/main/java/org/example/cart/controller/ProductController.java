package org.example.cart.controller;

import ch.qos.logback.core.model.Model;
import org.example.cart.model.Cart;
import org.example.cart.model.Product;
import org.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @ModelAttribute("cart")
    public Cart setCart(){
        return new Cart();
    }

    @GetMapping("/list")
    public String showProduct(Model model){
        model.addAttribute("listProduct",iProductService.findAll());
        return "/list";
    }
    @GetMapping("/addCart/{id}")
    public String addCart(@PathVariable("id") int id, Model model,@ModelAttribute("cart")Cart cart) {
        Product product=iProductService.findById(id);
        cart.addProduct(product);
        return "redirect:/cart_list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model,@ModelAttribute("cart")Cart cart) {
        Product product=iProductService.findById(id);
        model.addAttribute("product",product);
        return "/detail";
    }
    @GetMapping("")
    public String findAll(Model model){
        model.addAttribute("listProduct",iProductService.findAll());
        return "/product_list";
    }

}