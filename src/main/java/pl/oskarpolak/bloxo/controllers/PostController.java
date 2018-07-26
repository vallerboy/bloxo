package pl.oskarpolak.bloxo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.bloxo.models.forms.PostForm;

@Controller
public class PostController {

    @GetMapping("/post")
    public String post(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "addPost";
    }

    @PostMapping("/post")
    public String post(@ModelAttribute("postForm") PostForm postForm){
        System.out.println(postForm);
        return "redirect:/";
    }


}
