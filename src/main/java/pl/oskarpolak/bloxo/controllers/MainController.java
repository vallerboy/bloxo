package pl.oskarpolak.bloxo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.oskarpolak.bloxo.models.services.PostService;
import pl.oskarpolak.bloxo.models.services.SessionService;

import java.time.LocalDateTime;

@Controller
public class MainController {

    final SessionService sessionService;
    final PostService postService;
    @Autowired
    public MainController(SessionService sessionService, PostService postService) {
        this.sessionService = sessionService;
        this.postService = postService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("userObject", sessionService);
        model.addAttribute("posts", postService.getAllPosts());


        return "index";
    }

}
