package ordem_servico_api.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ordem_servico_api.demo.entity.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
}
