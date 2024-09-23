package fr.cda.trainingharrypotter.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {

    @NotBlank
    @NotNull
    private String name;


    @NotNull
    @Min(value = 0)
    private int yearOfBirth;

    private boolean isAlive;

    private Integer houseId;
}
