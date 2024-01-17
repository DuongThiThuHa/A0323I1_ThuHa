package codegym.vn.controller;

import codegym.vn.entity.Blog;
import codegym.vn.service.CategoryService;
import codegym.vn.service.impl.BlogServiceImpl;
import codegym.vn.service.impl.CategoryServiceImpl;
import codegym.vn.validate.BlogValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private BlogValidate blogValidate;


    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("blog") Blog blog,
                           BindingResult bindingResult, Model model) {
        blogValidate.validate(blog, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "blog/create";
        }
        blog.setCategory(categoryService.findById(blog.getCategory().getCategoryId()));
        blogService.create(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id, Model model){
        blogService.deleteById(id);
        model.addAttribute("result","Thanh cong !");
        return "redirect:/blog/list";
    }
}
