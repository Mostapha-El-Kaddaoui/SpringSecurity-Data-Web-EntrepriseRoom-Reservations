package ma.enset.exam1.Dao.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Temporal(TemporalType.DATE)
    Date date;
    int duration;
    String description;
    @Enumerated(EnumType.STRING)
    private ReservationType type;
    @ManyToOne
    private Salle salle;

    @ManyToOne
    private Employe employe;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "reservation_equipment",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private List<Equipement> equipments = new ArrayList<>();
}
