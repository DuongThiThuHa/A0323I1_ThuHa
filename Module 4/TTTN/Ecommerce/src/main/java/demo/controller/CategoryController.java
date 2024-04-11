package demo.controller;

import demo.common.ApiResponse;
import demo.model.Category;
import demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/create")
    public ResponseEntity< ApiResponse > createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "A new category created !"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Category> listCategory() {
        return categoryService.listCategory();
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity< ApiResponse > updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category){
        System.out.println("categoryId" + categoryId);
        if (!categoryService.findById(categoryId)){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category does not exists !"), HttpStatus.NOT_FOUND);
        }
        categoryService.editCategory(categoryId,category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Category has been updated !"), HttpStatus.OK);
    }
}
