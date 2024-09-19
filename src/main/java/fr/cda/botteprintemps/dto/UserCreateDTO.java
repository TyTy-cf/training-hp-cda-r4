package fr.cda.botteprintemps.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCreateDTO {

    @Email
    @NotNull
    private String email;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    private LocalDate birthAt;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String confirmedPassword;

}