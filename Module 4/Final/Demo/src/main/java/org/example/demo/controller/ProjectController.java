package org.example.demo.controller;

import org.example.demo.model.Project;
import org.example.demo.service.ICompanyService;
import org.example.demo.service.IProjectService;
import org.example.demo.validate.ProjectValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ICompanyService iCompanyService;
    @Autowired
    private IProjectService iProjectService;
    @Autowired
    private ProjectValidate projectValidate;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("projects", iProjectService.findAll());
        return "project/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("project", new Project());
        model.addAttribute("company", iCompanyService.findAll());
        return "project/create";
    }

    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("project") Project project, BindingResult bindingResult, Model model){
        projectValidate.validate(project,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("projects", iCompanyService.findAll());
            return "project/create";
        }
       project.setCompany(iCompanyService.findById(project.getCompany().getId()));
        iProjectService.create(project);
        return "redirect:/project/list";
    }



}
