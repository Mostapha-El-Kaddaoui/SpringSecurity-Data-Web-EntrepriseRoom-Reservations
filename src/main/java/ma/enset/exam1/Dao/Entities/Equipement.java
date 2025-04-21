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
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    float poids;

    @Enumerated(EnumType.STRING)
    private EquipementType type;

    @ManyToMany(mappedBy = "equipments", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();
}
