package ma.enset.exam1.Dto;

import ma.enset.exam1.Dao.Entities.Employe;
import ma.enset.exam1.Dao.Entities.Equipement;
import ma.enset.exam1.Dao.Entities.Reservation;
import ma.enset.exam1.Dao.Entities.Salle;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;


public class EntityMapper {
    private final ModelMapper modelMapper;

    public EntityMapper() {
        this.modelMapper = new ModelMapper();
    }

    public EmployeDTO fromEmploye(Employe employe) {
        return modelMapper.map(employe, EmployeDTO.class);
    }

    public Employe toEmploye(EmployeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employe.class);
    }

    public SalleDTO fromRoom(Salle salle) {
        return modelMapper.map(salle, SalleDTO.class);
    }

    public Salle toRoom(SalleDTO salleDTO) {
        return modelMapper.map(salleDTO, Salle.class);
    }

    public EquipmentDTO fromEquipment(Equipement equipement) {
        return modelMapper.map(equipement, EquipmentDTO.class);
    }

    public Equipement toEquipment(EquipmentDTO equipmentDTO) {
        return modelMapper.map(equipmentDTO, Equipement.class);
    }

    public ReservationDTO fromReservation(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setDate(reservation.getDate());
        dto.setDuration(reservation.getDuration());
        dto.setDescription(reservation.getDescription());
        dto.setType(reservation.getType());

        if (reservation.getEmploye() != null) {
            dto.setEmployeId(reservation.getEmploye().getId());
            dto.setEmployeNom(reservation.getEmploye().getNom());
        }

        if (reservation.getSalle() != null) {
            dto.setSalleId(reservation.getSalle().getId());
            dto.setSalleNom(reservation.getSalle().getNom());
        }

        if (reservation.getEquipments() != null) {
            dto.setEquipmentIds(reservation.getEquipments().stream()
                    .map(Equipement::getId)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public List<ReservationDTO> fromReservationList(List<Reservation> reservations) {
        return reservations.stream()
                .map(this::fromReservation)
                .collect(Collectors.toList());
    }

}
