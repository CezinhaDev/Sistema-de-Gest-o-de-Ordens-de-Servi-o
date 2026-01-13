package ordem_servico_api.demo.controller;


import jakarta.validation.Valid;
import ordem_servico_api.demo.Enums.StatusOS;
import ordem_servico_api.demo.entity.OrdemServico;
import ordem_servico_api.demo.entity.service.OrdemServicoService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    private final OrdemServicoService service;

    public OrdemServicoController(OrdemServicoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@Valid @RequestBody OrdemServico os) {
        return service.criar(os);
    }

    @GetMapping
    public List<OrdemServico> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public OrdemServico buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PatchMapping("/{id}/status")
    public OrdemServico atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusOS status) {
        return service.atualizarStatus(id, status);
    }
}
