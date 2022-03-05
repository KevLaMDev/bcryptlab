package kevDev.bcryptlab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
    String username;
    String password;

}
