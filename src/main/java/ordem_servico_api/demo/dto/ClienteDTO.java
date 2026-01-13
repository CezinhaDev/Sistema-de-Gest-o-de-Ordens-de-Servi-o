package ordem_servico_api.demo.dto;

// fto é usado para transferir dados de cliente entre camadas da aplicação
public record ClienteDTO(
        Long id,
        String nome,
        String cpf,
        String telefone
) {}
