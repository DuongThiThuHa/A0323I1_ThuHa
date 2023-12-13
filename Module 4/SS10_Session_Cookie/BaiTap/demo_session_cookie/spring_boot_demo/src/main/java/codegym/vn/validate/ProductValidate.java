package codegym.vn.validate;

import codegym.vn.entity.Product;
import codegym.vn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class ProductValidate implements Validator {
    @Autowired
    private ProductService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Product)) {
            return;
        }
        Product p = (Product) target;
        if (service.findById(p.getId()) != null) {
            errors.rejectValue("id", "id.duplicate", "ID bị trùng lặp");
        }
    }
}
