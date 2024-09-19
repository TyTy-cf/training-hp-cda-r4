package fr.cda.botteprintemps.dto.redditish;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDTO {

    @NotBlank(message = "Le pseudo doit être renseigné")
    private String nickname;

}
