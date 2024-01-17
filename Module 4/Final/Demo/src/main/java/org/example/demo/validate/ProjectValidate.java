package org.example.demo.validate;

import org.example.demo.model.Project;
import org.example.demo.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class ProjectValidate implements Validator {
    @Autowired
    private IProjectService iProjectService;


    @Override
    public boolean supports(Class< ? > clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Project)){
            return;
        }
        Project project = (Project) target;
        if (iProjectService.findById(project.getProject_id()) != null){
            errors.rejectValue("project_id", "project_id.duplicate", "Ma du an khong hop le !");
        }
        if (project.getDate() == null){
            errors.rejectValue("date", "date.empty", "Ngay dang ky khong hop le !");
        } else if (project.getDate().before(new Date())){
            errors.rejectValue("date", "date.invalid","Ngay dang ky khong hop le !");
        }
    }
}
