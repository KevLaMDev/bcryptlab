package kevDev.bcryptlab.controller;

import kevDev.bcryptlab.model.Post;
import kevDev.bcryptlab.model.Utente;
import kevDev.bcryptlab.repository.PostRepository;
import kevDev.bcryptlab.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class PostController
{
    @Autowired
    PostRepository postRepo;
    @Autowired
    UtenteRepository userRepo;

    @PostMapping("/add-post")
    public RedirectView addPost(String title, String body, long utenteId, RedirectAttributes redirectAttributes) {
        Utente utente = userRepo.getById(utenteId);
        String username = utente.getUsername();
        Post newPost = new Post(title, body);
        newPost.setPostsOfUser(utente);
        postRepo.save(newPost);
        redirectAttributes.addFlashAttribute("utente", utente);
        return new RedirectView("/posts/" + username);
    }

    @GetMapping("/posts/{username}")
    public String getPostPage(@PathVariable String username, Utente utente, Model m) {
        Utente currentUser = userRepo.findByUsername(username);
        m.addAttribute("username", username);
        m.addAttribute("utente", currentUser);
        m.addAttribute("posts", currentUser.getPosts());
        return "posts.html";
    }


}
