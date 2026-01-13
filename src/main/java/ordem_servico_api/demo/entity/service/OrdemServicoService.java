package ordem_servico_api.demo.entity.service;


import org.springframework.stereotype.Service;

import ordem_servico_api.demo.Enums.StatusOS;
import ordem_servico_api.demo.Repository.OrdemServicoRepository;
import ordem_servico_api.demo.entity.OrdemServico;
import ordem_servico_api.demo.exception.BusinessException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository repository;

    public OrdemServicoService(OrdemServicoRepository repository) {
        this.repository = repository;
    }

    public OrdemServico criar(OrdemServico os) {
        os.setStatus(StatusOS.ABERTA);
        os.setDataAbertura(LocalDateTime.now());
        return repository.save(os);
    }

    public OrdemServico atualizarStatus(Long id, StatusOS status) {
        OrdemServico os = buscarPorId(id);

        if (status == StatusOS.CONCLUIDA) {
            os.setDataFechamento(LocalDateTime.now());
        }

        os.setStatus(status);
        return repository.save(os);
    }

    public OrdemServico buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BusinessException("Ordem de Serviço não encontrada"));
    }

    public List<OrdemServico> listarTodas() {
        return repository.findAll();
    }
}
