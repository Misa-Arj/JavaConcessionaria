package JavaConcessionaria.api.model.dto;
import JavaConcessionaria.api.model.Cliente;
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
)
{
    public ClienteDto(Cliente cliente){
        this(cliente.getNome_completo(),
                cliente.getEmail(),cliente.getCpf(),
                cliente.getTelefone(),new CarroDto(cliente.getCarro()));
    }

}
