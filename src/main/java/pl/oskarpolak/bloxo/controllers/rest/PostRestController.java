package pl.oskarpolak.bloxo.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.oskarpolak.bloxo.models.PostEntity;
import pl.oskarpolak.bloxo.models.UserEntity;
import pl.oskarpolak.bloxo.models.services.PostService;

import java.util.Optional;

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

    @GetMapping(value = "/post/{id}", produces = "application/json")
    public ResponseEntity onePost(@PathVariable("id") int id){
        return  postService.getPost(id)
                .map(s -> ResponseEntity.ok(s))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(value = "/post", consumes = "application/json")
    public ResponseEntity savePost(@RequestBody PostEntity postEntity){ //Można utworzyć nową klasę

       // System.out.println(postEntity);
        postService.savePost(postEntity);
        return ResponseEntity.ok(postEntity);
    }


    @DeleteMapping(value = "/post/{id}", produces = "application/json")
    public ResponseEntity deletePost(@PathVariable("id") int id){
       postService.deletePostById(id);

       return ResponseEntity.ok().build();
    }


}
