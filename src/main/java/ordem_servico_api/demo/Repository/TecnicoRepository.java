package ordem_servico_api.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ordem_servico_api.demo.entity.Tecnico;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

    Optional<Tecnico> findByCpf(String cpf);
}
