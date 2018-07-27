package pl.oskarpolak.bloxo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.bloxo.models.forms.PostForm;
import pl.oskarpolak.bloxo.models.services.PostService;
import pl.oskarpolak.bloxo.models.services.SessionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PostController {

    final PostService postService;
    final SessionService sessionService;



    @Autowired
    public PostController(PostService postService, SessionService sessionService) {
        this.postService = postService;
        this.sessionService = sessionService;
    }



    @GetMapping("/post")
    public String post(Model model) {
        if(!sessionService.isLogin()){
            return "redirect:/login";
        }
        model.addAttribute("postForm", new PostForm());
        return "addPost";
    }

    @PostMapping("/post")
    public String post(@ModelAttribute("postForm") PostForm postForm){
        postService.addPost(postForm);
        return "redirect:/";
    }


    @GetMapping("/post/{id}")
    public String post(@PathVariable("id") int id,
                       Model model){
        model.addAttribute("postData",  postService.getAllPostData(id));
        return "showPost";
    }

}
