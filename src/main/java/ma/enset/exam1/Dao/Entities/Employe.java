package ma.enset.exam1.Dao.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employe")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String email;

    @OneToMany(mappedBy = "employe", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();
}
