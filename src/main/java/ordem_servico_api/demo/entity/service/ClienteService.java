package ordem_servico_api.demo.entity.service;

import org.springframework.stereotype.Service;

import ordem_servico_api.demo.Repository.ClienteRepository;
import ordem_servico_api.demo.entity.Cliente;
import ordem_servico_api.demo.exception.BusinessException;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) { // Injeção de dependência
        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente) { // Validação de CPF único
        repository.findByCpf(cliente.getCpf())
                .ifPresent(c -> {
                    throw new BusinessException("CPF já cadastrado");
                });

        return repository.save(cliente);
    }

    public List<Cliente> listarTodos() { // Listar todos os clientes
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) { // Buscar cliente por ID
        return repository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
    }
}
