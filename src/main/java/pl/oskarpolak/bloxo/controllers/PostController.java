package pl.oskarpolak.bloxo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.bloxo.models.forms.PostForm;
import pl.oskarpolak.bloxo.models.services.PostService;

@Controller
public class PostController {

    final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public String post(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "addPost";
    }

    @PostMapping("/post")
    public String post(@ModelAttribute("postForm") PostForm postForm){
        postService.addPost(postForm);
        return "redirect:/";
    }



}
