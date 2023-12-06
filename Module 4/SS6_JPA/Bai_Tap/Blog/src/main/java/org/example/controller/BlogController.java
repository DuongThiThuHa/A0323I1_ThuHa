package org.example.controller;

import org.example.model.Blog;
import org.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String showIndex(Model model){
        model.addAttribute("blogs", iBlogService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }

    @GetMapping("/{id}/view")
    public String showView(Model model, @PathVariable("id") int id){
        model.addAttribute("blog" , iBlogService.findById(id));
        return "view";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(Model model, @PathVariable("id") int id) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "edit";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(Model model, @PathVariable("id") int id) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "delete";
    }

    @PostMapping("/create")
    public String create(Blog blog) {
        iBlogService.create(blog);
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(Blog blog) {
        iBlogService.deleteById(blog.getId());
        return "redirect:/blog";
    }

    @PostMapping("/edit")
    public String edit(Blog blog) {
        iBlogService.update(blog);
        return "redirect:/blog";
    }
}
