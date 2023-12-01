package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("blog", iBlogService.findAll());
        return "view/blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", iCategoryService.findAll());
        return "view/blog/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute(value = "blog") Blog blog) {
        blog.setCategory(iCategoryService.findById(blog.getCategory().getCategoryId()));
        iBlogService.create(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/update")
    public String showUpdate(Model model, @RequestParam("id") int id) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("category", iCategoryService.findAll());
        return "view/blog/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog) {
        blog.setCategory(iCategoryService.findById(blog.getCategory().getCategoryId()));
        iBlogService.update(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/search")
    public String showSearch(Model model, @RequestParam("blogName") String name) {
        model.addAttribute("blog", iBlogService.findAllByName(name));
        return "view/blog/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "view/blog/detail";
    }

    @GetMapping("/list_slice")
    public String showListPagingSlice(
            Model model, @RequestParam(name = "page", defaultValue = "1", required = false)
    int pageNumber, @RequestParam(name = "pageSize", required = false, defaultValue = "3") int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber -1, pageSize);
        Slice<Blog> blogs = iBlogService.findAllSlice(pageable);
        model.addAttribute("blog",blogs);
        model.addAttribute("pageSize",pageSize);
        return "/view/blog/list_slice";
    }

}
