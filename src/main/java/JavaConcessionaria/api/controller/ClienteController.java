package JavaConcessionaria.api.controller;

import JavaConcessionaria.api.model.Carro;
import JavaConcessionaria.api.model.Cliente;
import JavaConcessionaria.api.model.dto.ClienteDto;
import JavaConcessionaria.api.service.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        service.salvar(new Cliente(dados));
        //carro.setData_compra(LocalDateTime.now(ZoneId.of("UTC")));
    }

}
