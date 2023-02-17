package JavaConcessionaria.api.model.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDto(
            @NotBlank
            String nome_completo,
            String email,
            @NotBlank
            String cpf,
            @NotBlank
            String telefone,
            @NotNull
            @Valid
            CarroDto carro
) {
}
