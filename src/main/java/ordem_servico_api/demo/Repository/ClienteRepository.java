package ordem_servico_api.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ordem_servico_api.demo.entity.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);
}
