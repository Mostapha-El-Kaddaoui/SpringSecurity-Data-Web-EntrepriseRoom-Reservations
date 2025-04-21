package ma.enset.exam1.Dao.Repository;

import ma.enset.exam1.Dao.Entities.Employe;
import ma.enset.exam1.Dao.Entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle,Long> {
    Salle findByNomContains(String nom);
}
