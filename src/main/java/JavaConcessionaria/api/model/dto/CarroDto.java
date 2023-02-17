package JavaConcessionaria.api.model.dto;

import JavaConcessionaria.api.model.enums.Marca;
import JavaConcessionaria.api.model.enums.Modelo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CarroDto(
        @NotNull
        Marca marca,
        @NotBlank
        String chassi,
        @NotBlank
        String placa,
        @NotNull
        Modelo modelo,
        @NotBlank
        String ano_fabricacao,
        @NotBlank
        String ano_modelo,
        @NotBlank
        String cor,
        @NotNull
        Integer quilometragem_atual
) {
}
