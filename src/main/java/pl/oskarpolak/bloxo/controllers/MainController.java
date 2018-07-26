package pl.oskarpolak.bloxo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.oskarpolak.bloxo.models.services.AuthService;
import pl.oskarpolak.bloxo.models.services.SessionService;

@Controller
public class MainController {

    final SessionService sessionService;

    @Autowired
    public MainController(SessionService sessionService) {
        this.sessionService = sessionService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("userObject", sessionService);
        return "index";
    }

}
