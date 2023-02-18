package JavaConcessionaria.api.service;

import JavaConcessionaria.api.model.Cliente;
import JavaConcessionaria.api.model.dto.ClienteDto;
import JavaConcessionaria.api.model.dto.exception.ObjetoNaoEncontradoException;
import JavaConcessionaria.api.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Transactional
    public void salvar (ClienteDto dto){
        repository.save(new Cliente(dto));
    }

    public Cliente findCliente(Integer id){
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(
                () -> new ObjetoNaoEncontradoException("Objeto não econtrado!"
                + " id:" + id));
    }
}
