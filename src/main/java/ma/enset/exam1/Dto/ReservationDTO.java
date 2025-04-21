package ma.enset.exam1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.exam1.Dao.Entities.ReservationType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Long id;
    private Date date;
    private int duration;
    private String description;
    private ReservationType type;
    private Long employeId;
    private String employeNom;
    private Long salleId;
    private String salleNom;
    private List<Long> equipmentIds = new ArrayList<>();


}
