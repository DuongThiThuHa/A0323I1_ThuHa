package org.example.exam.validate;

import org.example.exam.model.Blog;
import org.example.exam.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class BlogValidate implements Validator {
    @Autowired
    private IBlogService iBlogService;
    @Override
    public boolean supports(Class< ? > clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Blog)){
            return;
        }
        Blog blog = (Blog) target;
        if (blog.getDateRelease() == null){
            errors.rejectValue("dateRelease", "date.empty", "Ngay khong hop le");
        } else if (blog.getDateRelease().before(new Date())) {
            errors.rejectValue("dateRelease", "date.invalid", "Ngay khong hop le");
        }
    }
}
