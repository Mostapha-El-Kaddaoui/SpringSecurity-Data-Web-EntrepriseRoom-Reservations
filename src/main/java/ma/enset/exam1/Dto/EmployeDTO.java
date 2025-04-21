package ma.enset.exam1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDTO {
    private Long id;
    private String name;
    private String email;
}
