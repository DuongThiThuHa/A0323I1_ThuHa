package codegym.vn.validate;

import codegym.vn.entity.Blog;
import codegym.vn.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class BlogValidate implements Validator {
    @Autowired
    private BlogServiceImpl blogService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Blog)) {
            return;
        }
        Blog b = (Blog) target;
        if (b.getDateRelease() == null) {
            errors.rejectValue("dateRelease", "date.empty", "Ngày không hợp lệ");
        } else if (b.getDateRelease().before(new Date())) {
            errors.rejectValue("dateRelease", "date.invalid", "Ngày không hợp lệ");
        }
    }
}
