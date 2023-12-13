package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.Rent;
import com.example.book.service.IBookService;
import com.example.book.service.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/rent")
public class RentController {
    @Autowired
    private IRentService iRentService;
    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("rent", iRentService.findAll());
        return "/rent_list";
    }

    @GetMapping("/create")
    public String showRent(Model model, @RequestParam("id") int id){
        model.addAttribute("book", iBookService.findById(id));
        return "/rent";
    }

    @PostMapping("/create")
    public String doRent(Book book, RedirectAttributes redirectAttributes){
        try {
            book.setQuantity(book.getQuantity() -1);
            iBookService.rent(book);
            return "redirect:/book";
        }catch (Exception e){
            redirectAttributes.addAttribute("Error","Quantity = 0");
            return "redirect:/book";
        }
    }

    @GetMapping("/back")
    public String showGiveBack(){
        return "/give_back";
    }

    @PostMapping("/back")
    public String doBack(RedirectAttributes redirectAttributes, @RequestParam("rend_id") String id){
        Rent rent = iRentService.findById(id);
        if (rent == null){
            redirectAttributes.addFlashAttribute("Error","Not find rent id");
            return "redirect:/rent/back";
        }
        Book book = rent.getBook();
        book.setQuantity(book.getQuantity() +1);
        iRentService.delete(rent);
        iBookService.rent(book);
        redirectAttributes.addFlashAttribute("Error","Give back that book successfully!");
        return "redirect:/book";
    }
}
