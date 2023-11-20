package org.example.controller;

import jdk.internal.classfile.impl.BufferedCodeBuilder;
import org.example.model.Image;
import org.example.service.IImageService;
import org.example.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private IImageService iImageService = new ImageService();

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("image",new Image());
        model.addAttribute("images",iImageService.findAll());
        return "/index";
    }

    @PostMapping("/create")
    public String save (@ModelAttribute("image") Image image){
        iImageService.save(image);
        return "redirect:/image";
    }

}
