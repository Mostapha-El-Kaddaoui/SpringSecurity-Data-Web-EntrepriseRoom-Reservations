package ma.enset.exam1.Dao.Entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String numero;
    String nom;
    int nbrPlace;
    @Enumerated(EnumType.STRING)
    private SalleType type;

    @OneToMany(mappedBy = "salle", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();
}
