package org.example.furama4.controller.employee;

import org.example.furama4.model.employee.Employee;
import org.example.furama4.service.employee.IDivisionService;
import org.example.furama4.service.employee.IEducationDegreeService;
import org.example.furama4.service.employee.IEmployeeService;
import org.example.furama4.service.employee.IPositionService;
import org.example.furama4.service.role.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public String displayEmployeeList(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size")Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        Page<Employee> employees = iEmployeeService.findAll((java.awt.print.Pageable) pageable);
        model.addAttribute("employees", employees);
        int totalPage = employees.getTotalPages();
        if (totalPage > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "employee/list";
    }
    @GetMapping("/f")
    public String displayCreateEmployee(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("educationDegree", iEducationDegreeService.findAll());
        model.addAttribute("division", iDivisionService.findAll());
        model.addAttribute("position", iPositionService.findAll());
        model.addAttribute("user", iUserService.findAll());
        return "employee/create";
    }
    @PostMapping("/create")
    public String doCreateEmployee(@ModelAttribute("employee") Employee employee){
        iEmployeeService.create(employee);
        return "redirect:/employee/list";
    }
    @GetMapping("/detail")
    public String displayDetail(Model model, @RequestParam("id") int id) {
        Employee employee = iEmployeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee/detail";
    }
    @GetMapping("/update")
    public String displayUpdate(Model model, @RequestParam("id") int id) {
        iEmployeeService.findEmployeeById(id);
        model.addAttribute("employee",  iEmployeeService.findEmployeeById(id));
        model.addAttribute("educationDegree", iEducationDegreeService.findAll());
        model.addAttribute("division", iDivisionService.findAll());
        model.addAttribute("position", iPositionService.findAll());
        model.addAttribute("user", iUserService.findAll());
        return "employee/update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Employee employee, @PathVariable("id") int id) {
        iEmployeeService.fix(iEmployeeService  .findEmployeeById(id));
        return "redirect:/employee/list";
    }
}
