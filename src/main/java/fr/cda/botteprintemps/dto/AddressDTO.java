package fr.cda.botteprintemps.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDTO {

    @NotBlank
    @NotNull
    private String street;

    @Max(6)
    private String number;

    @NotBlank
    @NotNull
    private String zipcode;

    @NotBlank
    @NotNull
    private String city;

    @NotBlank
    @NotNull
    private String country;

    @NotNull
    private float longitude;

    @NotNull
    private float latitude;

    private String more;

}