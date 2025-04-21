package ma.enset.exam1.Dao.Repository;

import ma.enset.exam1.Dao.Entities.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipementRepository extends JpaRepository<Equipement,Long> {

}
