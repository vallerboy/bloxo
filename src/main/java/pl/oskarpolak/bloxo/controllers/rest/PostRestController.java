package pl.oskarpolak.bloxo.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.oskarpolak.bloxo.models.services.PostService;

@RestController
@RequestMapping("rest")
public class PostRestController {
    final PostService postService;

    @Autowired
    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/post", produces = "application/json")
    public ResponseEntity allPost() {
        return ResponseEntity.ok(postService.getAllPosts());
    }
}
