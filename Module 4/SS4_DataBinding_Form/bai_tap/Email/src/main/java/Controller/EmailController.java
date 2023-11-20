package Controller;

import model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.IEmailService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {
    private IEmailService iEmailService;

    @Autowired
    public EmailController(IEmailService iEmailService) {
        this.iEmailService = iEmailService;
    }

    @GetMapping("/edit")
    public String displayEditForm(Model model, @RequestParam("id") String id) {
        model.addAttribute("email", iEmailService.findById(id));
        model.addAttribute("languages", getLanguages());
        model.addAttribute("sizes", getSizes());
        return "/edit";
    }

    @PostMapping("/edit")
    public String doEdit(@ModelAttribute("email") Email email) {
        iEmailService.update(email);
        return "redirect:/email";
    }

    @GetMapping("")
    public String displayListForm(Model model) {
        model.addAttribute("email", iEmailService.findAll());
        return "/list";
    }

    private Object getSizes() {
        List<Integer> sizes = new ArrayList<>();
        sizes.add(5);
        sizes.add(10);
        sizes.add(15);
        sizes.add(25);
        sizes.add(50);
        sizes.add(100);
        return sizes;
    }

    private Object getLanguages() {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        return languages;
    }
}
