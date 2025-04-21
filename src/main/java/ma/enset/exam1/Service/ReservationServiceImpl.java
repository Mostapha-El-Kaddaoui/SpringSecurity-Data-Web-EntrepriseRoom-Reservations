package ma.enset.exam1.Service;

import ma.enset.exam1.Dao.Entities.Salle;
import ma.enset.exam1.Dao.Repository.SalleRepository;
import ma.enset.exam1.Dto.ReservationDTO;
import ma.enset.exam1.Dao.Entities.Employe;
import ma.enset.exam1.Dao.Entities.Reservation;
import ma.enset.exam1.Dao.Repository.EmployeeRepository;
import ma.enset.exam1.Dao.Repository.ReservationRepository;
import ma.enset.exam1.Dto.ReservationMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService{

    private final ReservationRepository reservationRepository;
    private final EmployeeRepository employeeRepository;
    private final SalleRepository salleRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, EmployeeRepository employeeRepository, SalleRepository salleRepository){
        this.reservationRepository = reservationRepository;
        this.employeeRepository = employeeRepository;
        this.salleRepository = salleRepository;
    }
    @Override
    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
        Salle salle = salleRepository.findByNomContains(reservationDTO.getSalleNom());
        Employe employe = employeeRepository.findByNomContains(reservationDTO.getEmployeNom());
        Reservation reservation = ReservationMapper.toEntity(reservationDTO, salle, employe);
        Reservation savedReservation = reservationRepository.save(reservation);
        return ReservationMapper.toDTO(savedReservation);
    }

    @Override
    public List<ReservationDTO> getEmployeReservations(Long employeId) {
        return null;
    }

    @Override
    public Page<Reservation> findByEmployeNom(String employeNom, PageRequest pageRequest) {
        return reservationRepository.findByEmployeNom(employeNom, pageRequest);
    }

    @Override
    public Page<Reservation> findAll(PageRequest pageRequest) {
        return reservationRepository.findAll(pageRequest);
    }

}












