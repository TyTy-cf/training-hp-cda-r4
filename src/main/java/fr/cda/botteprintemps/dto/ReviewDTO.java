package fr.cda.botteprintemps.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewDTO {

    @NotNull
    @NotBlank
    private String content;

    private float rating;

    @NotNull
    private String userId;

    @NotNull
    private String lodgingId;

}