package kevDev.bcryptlab.repository;

import kevDev.bcryptlab.model.Post;
import kevDev.bcryptlab.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>
{

}

