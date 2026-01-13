package ordem_servico_api.demo.entity.service;


import org.springframework.stereotype.Service;

import ordem_servico_api.demo.Repository.TecnicoRepository;
import ordem_servico_api.demo.entity.Tecnico;
import ordem_servico_api.demo.exception.BusinessException;

import java.util.List;

@Service
public class TecnicoService {

    private final TecnicoRepository repository;

    public TecnicoService(TecnicoRepository repository) {
        this.repository = repository;
    }

    public Tecnico salvar(Tecnico tecnico) {
        repository.findByCpf(tecnico.getCpf())
                .ifPresent(t -> {
                    throw new BusinessException("CPF já cadastrado");
                });

        return repository.save(tecnico);
    }

    public List<Tecnico> listarTodos() {
        return repository.findAll();
    }

    public Tecnico buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BusinessException("Técnico não encontrado"));
    }
}
