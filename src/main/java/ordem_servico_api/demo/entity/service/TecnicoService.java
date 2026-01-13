package ordem_servico_api.demo.entity.service;

import ordem_servico_api.demo.Repository.ClienteRepository;
import ordem_servico_api.demo.entity.Cliente;
import ordem_servico_api.demo.exception.BusinessException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoService {

    private final ClienteRepository repository;

    public TecnicoService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente) {
        repository.findByCpf(cliente.getCpf())
                .ifPresent(c -> {
                    throw new BusinessException("CPF já cadastrado");
                });

        return repository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
    }
}
