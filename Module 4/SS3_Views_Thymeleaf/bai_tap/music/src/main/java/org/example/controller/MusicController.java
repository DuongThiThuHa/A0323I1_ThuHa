package org.example.controller;

import org.example.model.Music;
import org.example.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MusicController {
    private MusicService musicService = new MusicService();
    @GetMapping("list")
    public String show(Model model){
        model.addAttribute("list",musicService.getAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music",new Music());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Music music, Model model){
        String regex = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$"; // Biểu thức chính quy cho URL hợp lệ
        boolean matches = Pattern.matches(regex, music.getLink());
        if (matches){
            musicService.create(music);
            model.addAttribute("Message","Thanh Cong");
            return "redirect:/list";
        }else {
            model.addAttribute("Message","That Bai");
            return "create";
        }
    }
}
