package ma.enset.exam1.Dao.Repository;

import ma.enset.exam1.Dao.Entities.Employe;
import ma.enset.exam1.Dao.Entities.Reservation;
import ma.enset.exam1.Dao.Entities.ReservationType;
import ma.enset.exam1.Dao.Entities.Salle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByEmploye(Employe employe);
    Page<Reservation> findByEmployeId(Long employeeId, Pageable pageable);
    Page<Reservation> findByEmployeNom(String employeNom, Pageable pageable);
    List<Reservation> findBySalle(Salle salle);
    List<Reservation> findByType(ReservationType reservationType);
}
