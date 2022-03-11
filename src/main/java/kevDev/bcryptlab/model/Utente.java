package kevDev.bcryptlab.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
    String username;
    String password;

    @OneToMany(mappedBy = "postsOfUser", cascade=CascadeType.ALL) // if the user is deleted, get rid of all posts associated with the user
    List<Post> posts;

    public Utente(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Utente() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
