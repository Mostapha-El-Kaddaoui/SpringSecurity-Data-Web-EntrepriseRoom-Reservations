package ma.enset.exam1.Dao.Repository;

import ma.enset.exam1.Dao.Entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employe, Long> {
    Employe findByNomContains(String nom);
}
