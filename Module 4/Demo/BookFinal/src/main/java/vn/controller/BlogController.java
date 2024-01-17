package vn.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.model.Blog;
import vn.service.IBlogService;
import vn.service.ICategoryService;
import vn.validate.BlogValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private BlogValidate blogValidate;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("blogs", iBlogService.findAll());
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", iCategoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("blog") Blog blog, BindingResult bindingResult, Model model) {
        blogValidate.validate(blog, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", iCategoryService.findAll());
            iBlogService.create(blog);
            return "redirect:/blog/list";
        }
        blog.setCategory(iCategoryService.findById(blog.getCategory().getCategoryId()));
        iBlogService.create(blog);
        return "redirect:/blog/list";
    }
}
