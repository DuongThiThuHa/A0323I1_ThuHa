package org.example.blog.controller;

import org.example.blog.model.Blog;
import org.example.blog.model.BlogCategory;
import org.example.blog.service.BlogCategoryService;
import org.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogCategoryService blogCategoryService;

    @GetMapping("/category/list")
    public ResponseEntity< List< BlogCategory > > getCategory() {
        List<BlogCategory> list = blogCategoryService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/blog/list")
    public ResponseEntity<List<Blog>> getAllBlog() {
        List< Blog > blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> getBlog(@PathVariable Integer id){
        List<Blog> list = (List< Blog >) blogService.findById(id);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
