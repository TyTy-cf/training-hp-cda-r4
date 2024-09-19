package fr.cda.botteprintemps.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LodgingDTO {

    @NotBlank
    @NotNull
    private String name;

    @Min(1)
    private int capacity;

    @NotBlank
    private boolean isAccessible;

    @Min(1)
    private int nightPrice;

    private String description;

    @NotNull
    private AddressDTO addressDTO;

}