package kevDev.bcryptlab.repository;

import kevDev.bcryptlab.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long>
{
    Utente findByUsername(String username);
}

