package ordem_servico_api.demo.dto;

import java.time.LocalDateTime;

import ordem_servico_api.demo.Enums.StatusOS;

public record OrdemServicoDTO(
        Long id,
        String descricao,
        ClienteDTO cliente,
        TecnicoDTO tecnico,
        StatusOS status,
        LocalDateTime dataAbertura,
        LocalDateTime dataFechamento
) {}
