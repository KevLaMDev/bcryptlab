package kevDev.bcryptlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UtenteController {
    @GetMapping("/")
    public String renderLoginPage() {
        return "index.html";
    }

    @PostMapping("/login")
    public RedirectView login(String username, String password) {
        return new RedirectView("/home");
    }
}
