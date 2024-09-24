package fr.cda.trainingharrypotter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HouseDTO {

    @NotBlank
    private String houseName;

    @NotBlank
    private String founderFirstName;

    @NotBlank
    private String founderLastName;

}
