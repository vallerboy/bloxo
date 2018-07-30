package pl.oskarpolak.bloxo.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.oskarpolak.bloxo.controllers.AuthController;
import pl.oskarpolak.bloxo.models.forms.RegisterForm;
import pl.oskarpolak.bloxo.models.services.AuthService;

@RestController
@RequestMapping("rest")
public class UserRestController {
    final AuthService authService;

    @Autowired
    public UserRestController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping(value = "/user", produces = "application/json")
    public ResponseEntity getAllUsers(@RequestHeader("Api-Key") String key){
        if(!key.equals("tajnehaslo")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Key do not exist");
        }

        return ResponseEntity.ok(authService.getAllUsers());
    }

    @GetMapping(value = "/user/{email}", produces = "application/json")
    public ResponseEntity getUserByEmail(@PathVariable("email") String email){
        return authService.findByEmail(email)
                .map(s -> ResponseEntity.ok(s))
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity addUser(@RequestBody RegisterForm registerForm){
         return authService.tryToRegister(registerForm)
                 ? ResponseEntity.ok().build()
                 : ResponseEntity.badRequest().build();
    }

}

