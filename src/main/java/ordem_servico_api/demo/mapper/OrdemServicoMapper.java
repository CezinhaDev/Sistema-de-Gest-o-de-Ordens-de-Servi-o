package ordem_servico_api.demo.mapper;

import ordem_servico_api.demo.dto.ClienteDTO;
import ordem_servico_api.demo.dto.OrdemServicoDTO;
import ordem_servico_api.demo.dto.TecnicoDTO;
import ordem_servico_api.demo.entity.OrdemServico;

public class OrdemServicoMapper {

    public static OrdemServicoDTO toDTO(OrdemServico os) {
        return new OrdemServicoDTO(
                os.getId(),
                os.getDescricao(),
                new ClienteDTO(
                        os.getCliente().getId(),
                        os.getCliente().getNome(),
                        os.getCliente().getCpf(),
                        os.getCliente().getTelefone()
                ),
                new TecnicoDTO(
                        os.getTecnico().getId(),
                        os.getTecnico().getNome(),
                        os.getTecnico().getCpf(),
                        os.getTecnico().getTelefone()
                ),
                os.getStatus(),
                os.getDataAbertura(),
                os.getDataFechamento()
        );
    }
}
