package kevDev.bcryptlab.model;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(columnDefinition = "text")
    String title;
    String body;

    @ManyToOne
//    @JoinColumn(name="utente_id")
    Utente postsOfUser;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Utente getPostsOfUser() {
        return postsOfUser;
    }

    public void setPostsOfUser(Utente postsOfUser) {
        this.postsOfUser = postsOfUser;
    }
}
