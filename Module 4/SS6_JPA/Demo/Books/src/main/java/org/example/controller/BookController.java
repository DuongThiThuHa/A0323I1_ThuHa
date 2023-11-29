package org.example.controller;

import org.dom4j.rule.Mode;
import org.example.model.Book;
import org.example.service.IBookService;
import org.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("Book", iBookService.findAll());
        return "/view/book/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("categories",iCategoryService.findAll());
        return "/book/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("book") Book book){
        book.setCategory(iCategoryService.findById(book.getCategory().getCategoryId()));
        iBookService.create(book);
        return "redirect:view/book/list";
    }

    @GetMapping("/search")
    public String showSearch(Model model, @RequestParam("book_name") String name) {
        model.addAttribute("book", iBookService.findAllByName(name));
        return "view/book/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id) {
        Book book = iBookService.findById(id);
        model.addAttribute("book", book);
        return "view/book/detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        model.addAttribute("categories", iCategoryService.findAll());
        return "view/book/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("book") Book book) {
        book.setCategory(iCategoryService.findById(book.getCategory().getCategoryId()));
        iBookService.edit(book);
        return "redirect:view/book/list";
    }
}
