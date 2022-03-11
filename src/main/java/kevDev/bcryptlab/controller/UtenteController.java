package kevDev.bcryptlab.controller;

import kevDev.bcryptlab.model.Utente;
import kevDev.bcryptlab.repository.UtenteRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.persistence.GeneratedValue;
import java.awt.image.renderable.RenderableImage;

@Controller
public class UtenteController {
    @Autowired
    UtenteRepository utenteRepository;

    @GetMapping("/")
    public String renderLoginPage() {
        return "signin";
    }

    @PostMapping("/signin")
    public RedirectView signin(String username, String password, Model m, RedirectAttributes redirectAttributes) {
        Utente supposedUser = utenteRepository.findByUsername(username);
        if (supposedUser != null && (BCrypt.checkpw(password, supposedUser.getPassword()))) {
//              Long userId = supposedUser.getId();
              redirectAttributes.addFlashAttribute("utente", supposedUser);
            return new RedirectView("/home");
        } else {
            return new RedirectView("/badLogin");
        }
    }



    @GetMapping("/badLogin")
    public String getBadLoginPage() {
        return "/badLogin";
    }

    @GetMapping("/signup")
    public String getSignupPage() {
        return "/signup";
    }

    @PostMapping("/signup")
    public RedirectView signup(String username, String password) {
        String hashedPW = BCrypt.hashpw(password, BCrypt.gensalt());
        Utente nuovoUtente = new Utente(username, hashedPW);
        utenteRepository.save(nuovoUtente);
        return new RedirectView("/home");
    }



}
