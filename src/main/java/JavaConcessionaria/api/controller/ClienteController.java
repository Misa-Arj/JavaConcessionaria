package JavaConcessionaria.api.controller;

import JavaConcessionaria.api.model.Carro;
import JavaConcessionaria.api.model.Cliente;
import JavaConcessionaria.api.model.dto.ClienteDto;
import JavaConcessionaria.api.service.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ClienteDto dados){
        //var carro = new Carro();
        service.salvar(dados);
        //carro.setData_compra(LocalDateTime.now(ZoneId.of("UTC")));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StringBuffer> findCliente(@PathVariable Integer id){
        Cliente cliente = service.findCliente(id);

        StringBuffer sb = new StringBuffer("Cliente{\n");
        sb.append("Id: ").append(id).append("\n");
        sb.append(" Nome: ").append(cliente.getNome_completo()).append("\n");
        sb.append( "Email: ").append(cliente.getEmail()).append("\n");
        sb.append(" CPF: ").append(cliente.getCpf()).append("\n");
        sb.append(" Telefone: ").append(cliente.getTelefone()).append("\n");
        sb.append(" Marca: ").append(cliente.getCarro().getMarca()).append("\n");
        sb.append(" Chassi: ").append(cliente.getCarro().getChassi()).append("\n");
        sb.append(" Placa: ").append(cliente.getCarro().getPlaca()).append("\n");
        sb.append(" Modelo: ").append(cliente.getCarro().getModelo()).append("\n");
        sb.append(" Ano de Fabricação: ").append(cliente.getCarro().getAno_fabricacao()).append("\n");
        sb.append(" Ano Modelo: ").append(cliente.getCarro().getAno_modelo()).append("\n");
        sb.append(" Cor do Veículo: ").append(cliente.getCarro().getCor()).append("\n");
        sb.append("}");

        return ResponseEntity.ok().body(sb);
    }
}
