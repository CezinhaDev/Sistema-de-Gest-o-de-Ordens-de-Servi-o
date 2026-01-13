package ordem_servico_api.demo.controller;


import jakarta.validation.Valid;
import ordem_servico_api.demo.entity.Tecnico;
import ordem_servico_api.demo.entity.service.TecnicoService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    private final TecnicoService service;

    public TecnicoController(TecnicoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tecnico criar(@Valid @RequestBody Tecnico tecnico) {
        return service.salvar(tecnico);
    }

    @GetMapping
    public List<Tecnico> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Tecnico buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
