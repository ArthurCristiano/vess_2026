package br.edu.utfpr.pb.pw45s.projetofinal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserSignupDTO(

        @NotBlank(message = "O nome de usuário não pode ser nulo.")
        @Size(min = 4, max = 50, message = "O nome de usuário deve ter entre 4 e 50 caracteres.")
        String username,

        @NotBlank(message = "O email não pode ser nulo.")
        @Email(message = "O formato do email é inválido.")
        String email,

        @NotBlank(message = "A instituição não pode ser nula.")
        @Size(min = 2, max = 100, message = "A instituição deve ter entre 2 e 100 caracteres.")
        String institution,

        @NotBlank(message = "O país não pode ser nulo.")
        @Size(min = 2, max = 50, message = "O país deve ter entre 2 e 50 caracteres.")
        String country,

        @NotBlank(message = "O estado não pode ser nulo.")
        @Size(min = 2, max = 50, message = "O estado deve ter entre 2 e 50 caracteres.")
        String state,

        @NotBlank(message = "A cidade não pode ser nula.")
        @Size(min = 2, max = 50, message = "A cidade deve ter entre 2 e 50 caracteres.")
        String city,

        @NotBlank(message = "A senha não pode ser nula.")
        @Size(min = 6, max = 100, message = "A senha deve ter no mínimo 6 caracteres.")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "A senha deve conter pelo menos uma letra minúscula, uma letra maiúscula e um número.")
        String password
) {
}