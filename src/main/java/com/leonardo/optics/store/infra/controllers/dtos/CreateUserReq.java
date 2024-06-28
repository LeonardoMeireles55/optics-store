package com.leonardo.optics.store.infra.controllers.dtos;

import com.leonardo.optics.store.infra.constants.Roles;
import jakarta.validation.constraints.*;

import java.util.List;


public record CreateUserReq(
        @NotBlank(message = "First name is mandatory")
        @Size(min = 2, message = "First name must have at least 2 characters")
        String firstName,

        @NotBlank(message = "Last name is mandatory")
        @Size(min = 2, message = "Last name must have at least 2 characters")
        String lastName,

        @NotBlank(message = "Password is mandatory")
        @Size(min = 6, message = "Password must have at least 6 characters")
        String password,

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "CEP is mandatory")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP should be in the format 12345-678")
        String cep,

        @NotBlank(message = "Address is mandatory")
        String address,

        @NotBlank(message = "Telephone is mandatory")
        @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Telephone should be in the format (12) 34567-8901")
        String telephone,

        @NotBlank(message = "CPF is mandatory")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF should be in the format 123.456.789-10")
        String cpf,

        @NotNull(message = "Role is mandatory")
        Roles role,
        List<Long> userDependents
) {
}
