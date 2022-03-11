package kevDev.bcryptlab.controller;

import kevDev.bcryptlab.model.Post;
import kevDev.bcryptlab.model.Utente;
import kevDev.bcryptlab.repository.PostRepository;
import kevDev.bcryptlab.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    PostRepository postRepository;

    @GetMapping("/home")
    public String getHomePage(Model m, Utente utente) {
        m.addAttribute("utente", utente);
        return "home.html";
    }

}
