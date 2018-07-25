package pl.oskarpolak.bloxo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.oskarpolak.bloxo.models.forms.RegisterForm;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password) {
        //todo logika logowania
        System.out.println(email + " " + password);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute("registerForm") RegisterForm registerForm){
        //todo logika rejestracji
        System.out.println(registerForm);
        return "redirect:/login"; //Po rejestracji przenies na logowanie
    }
}
