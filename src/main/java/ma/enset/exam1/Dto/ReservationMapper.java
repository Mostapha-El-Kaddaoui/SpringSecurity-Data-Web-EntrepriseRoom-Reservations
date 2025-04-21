package ma.enset.exam1.Dto;

import ma.enset.exam1.Dao.Entities.Employe;
import ma.enset.exam1.Dao.Entities.Reservation;
import ma.enset.exam1.Dao.Entities.Salle;

public class ReservationMapper {

    public static ReservationDTO toDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setSalleNom(reservation.getSalle().getNom());
        dto.setEmployeNom(reservation.getEmploye().getNom());
        dto.setDate(reservation.getDate());
        return dto;
    }


    public static Reservation toEntity(ReservationDTO dto, Salle salle, Employe employe) {
        Reservation reservation = new Reservation();
        reservation.setDescription(dto.getDescription());
        reservation.setDuration(dto.getDuration());
        reservation.setType(dto.getType());
        reservation.setSalle(salle);
        reservation.setEmploye(employe);
        reservation.setDate(dto.getDate());
        return reservation;
    }
}
