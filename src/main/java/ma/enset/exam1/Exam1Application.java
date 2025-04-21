package ma.enset.exam1;

import ma.enset.exam1.Dao.Entities.*;
import ma.enset.exam1.Dao.Repository.EmployeeRepository;
import ma.enset.exam1.Dao.Repository.EquipementRepository;
import ma.enset.exam1.Dao.Repository.ReservationRepository;
import ma.enset.exam1.Dao.Repository.SalleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class Exam1Application {

    public static void main(String[] args) {
        SpringApplication.run(Exam1Application.class, args);
    }
    @Bean
    CommandLineRunner start(
            EmployeeRepository employeeRepository,
            SalleRepository roomRepository,
            EquipementRepository equipmentRepository,
            ReservationRepository reservationRepository
    ){
        return args -> {
            // Create employees
            Employe emp1 = new Employe(null, "John Doe", "john@example.com", null);
            Employe emp2 = new Employe(null, "Jane Smith", "jane@example.com", null);
            employeeRepository.saveAll(Arrays.asList(emp1, emp2));

            // Create rooms
            Salle room1 = new Salle(null, "A101", "Main Conference", 20, SalleType.REUNION, null);
            Salle room2 = new Salle(null, "B202", "Training Room", 15, SalleType.COURS, null);
            Salle room3 = new Salle(null, "C303", "Lab Room", 10, SalleType.TP, null);
            roomRepository.saveAll(Arrays.asList(room1, room2, room3));

            // Create equipment
            Equipement eq1 = new Equipement(null, "Projector Model X1", 2.5f, EquipementType.VIDEO_PROJECTEUR, null);
            Equipement eq2 = new Equipement(null, "HD Camera", 1.2f, EquipementType.CAMERA, null);
            Equipement eq3 = new Equipement(null, "Interactive Board", 15.0f, EquipementType.TABLEAU_INTERACTIF, null);
            equipmentRepository.saveAll(Arrays.asList(eq1, eq2, eq3));

            // Create reservations
            Reservation res1 = new Reservation();
            res1.setDate(new Date());
            res1.setDuration(60);
            res1.setDescription("Team meeting");
            res1.setType(ReservationType.VALIDATED);
            res1.setEmploye(emp1);
            res1.setSalle(room1);
            res1.setEquipments(Arrays.asList(eq1, eq2));

            Reservation res2 = new Reservation();
            res2.setDate(new Date());
            res2.setDuration(120);
            res2.setDescription("Training session");
            res2.setType(ReservationType.PENDING);
            res2.setEmploye(emp2);
            res2.setSalle(room2);
            res2.setEquipments(Arrays.asList(eq1, eq3));

            reservationRepository.saveAll(Arrays.asList(res1, res2));

            // Test queries
            System.out.println("=== Employee Reservations ===");
            employeeRepository.findById(emp1.getId()).ifPresent(e -> {
                reservationRepository.findByEmploye(e).forEach(r -> {
                    System.out.println("Reservation: " + r.getDescription() + ", Room: " + r.getSalle().getNom());
                });
            });

            System.out.println("=== Room Reservations ===");
            roomRepository.findById(room1.getId()).ifPresent(r -> {
                reservationRepository.findBySalle(r).forEach(res -> {
                    System.out.println("Reservation: " + res.getDescription() + ", Employee: " + res.getEmploye().getNom());
                });
            });
        };
    }

}
