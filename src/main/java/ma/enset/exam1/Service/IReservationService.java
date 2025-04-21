package ma.enset.exam1.Service;

import ma.enset.exam1.Dao.Entities.Reservation;
import ma.enset.exam1.Dto.ReservationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IReservationService {
    ReservationDTO saveReservation(ReservationDTO reservationDTO);
    List<ReservationDTO> getEmployeReservations(Long employeId);


    Page<Reservation> findByEmployeNom(String employeNom, PageRequest pageRequest);

    Page<Reservation> findAll(PageRequest of);
}
