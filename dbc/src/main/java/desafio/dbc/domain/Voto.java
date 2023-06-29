package desafio.dbc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pauta_id")
    private Long pautaId;

    @Column(name = "cooperado_id")
    private Long cooperadoId;

    @Column(name = "voto_sim")
    private boolean votoSim;

    public Voto(Long pautaId, Long cooperadoId, boolean votoSim) {
        this.pautaId = pautaId;
        this.cooperadoId = cooperadoId;
        this.votoSim = votoSim;
    }
}