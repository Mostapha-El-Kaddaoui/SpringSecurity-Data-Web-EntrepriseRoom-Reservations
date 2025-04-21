package ma.enset.exam1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.exam1.Dao.Entities.EquipementType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO {
    private Long id;
    private String nom;
    private double poids;
    private EquipementType type;
}
