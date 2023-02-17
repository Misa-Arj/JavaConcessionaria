package JavaConcessionaria.api.model;

import JavaConcessionaria.api.model.dto.ClienteDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


import java.time.LocalDateTime;

@Entity(name = "Cliente")
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Digite nome completo")
    private String nome_completo;
    @Email(message = "email invalido")
    private String email;
    @Column(name = "cpf", length = 11)
    //@CPF(message = "cpf invalido")
    @NotEmpty(message = "Campo CPF é obrigatório")
    private String cpf;
    @Column(name = "telefone", length = 11)
    private String telefone;

    @Embedded
    private Carro carro;

    public Cliente(ClienteDto dto){
        this.nome_completo = dto.nome_completo();
        this.email = dto.email();
        this.cpf = dto.cpf();
        this.telefone = dto.telefone();
        this.carro = new Carro(dto.carro());
    }

}
