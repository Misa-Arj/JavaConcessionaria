package JavaConcessionaria.api.model;

import JavaConcessionaria.api.model.dto.CarroDto;
import JavaConcessionaria.api.model.enums.Marca;
import JavaConcessionaria.api.model.enums.Modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Carro {
    @Enumerated(EnumType.STRING)
    private Marca marca;

    @NotEmpty(message = "digite os oitos últimos número do CHASSI")
    @Column(name = "chassi",length = 8)
    private String chassi;

    @Column(name = "placa",length = 7)
    private String placa;
    @Enumerated(EnumType.STRING)
    private Modelo modelo;

    @NotEmpty(message = "anoFabricacao é campo obrigatório")
    @Column(length = 4)
    private String ano_fabricacao;

    @NotEmpty(message = "anoModelo é campo obrigatório")
    @Column(length = 4)
    private String ano_modelo;

    private String cor;

    @NotEmpty(message = "quilometragemAtual é campo obrigatório")
    private Integer quilometragem_atual;

    //private Integer quilometragemMedia; fazer um calculo depois.

    //@Column(nullable = false)
    //private LocalDateTime data_compra;


    public Carro(CarroDto dto){
        this.marca = dto.marca();
        this.chassi = dto.chassi();
        this.placa = dto.placa();
        this.modelo = dto.modelo();
        this.ano_fabricacao = dto.ano_fabricacao();
        this.ano_modelo = dto.ano_modelo();
        this.cor = dto.cor();
        this.quilometragem_atual = dto.quilometragem_atual();

    }

    //private void calculo()



}
