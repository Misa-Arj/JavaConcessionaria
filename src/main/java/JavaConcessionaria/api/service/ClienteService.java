package JavaConcessionaria.api.service;

import JavaConcessionaria.api.model.Cliente;
import JavaConcessionaria.api.model.dto.ClienteDto;
import JavaConcessionaria.api.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Transactional
    public void salvar (Cliente dados){
        repository.save(dados);
    }
}
