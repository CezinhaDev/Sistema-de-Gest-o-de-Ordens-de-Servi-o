package ordem_servico_api.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ordem_servico_api.demo.Enums.StatusOS;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordens_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrdemServico implements Serializable { // implements usado para 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOS status;

    @Column(name = "data_abertura")
    private LocalDateTime dataAbertura;

    @Column(name = "data_fechamento")
    private LocalDateTime dataFechamento;

    @PrePersist
    public void prePersist() {
        this.dataAbertura = LocalDateTime.now();
        this.status = StatusOS.ABERTA;
    }
}
