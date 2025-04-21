package ma.enset.exam1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.exam1.Dao.Entities.SalleType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalleDTO {
    private Long id;
    private String numero;
    private String nom;
    private int nbrPlace;
    private SalleType type;
}
